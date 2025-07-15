package com.example.flawless.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

data class Post(
    val id: String = "",
    val userId: String = "",
    val username: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val description: String = "",
    val timestamp: Long = 0L,
    val favoritedBy: List<String> = emptyList()
)

// State baru untuk menampung data yang sudah dikelompokkan
data class PostFeedState(
    val isLoading: Boolean = false,
    // Kunci adalah nama bulan (e.g., "July 2025"), Value adalah daftar postingan
    val groupedPosts: Map<String, List<Post>> = emptyMap(),
    val error: String? = null
)

class PostViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val auth = Firebase.auth

    private val _postFeedState = MutableStateFlow(PostFeedState())
    val postFeedState = _postFeedState.asStateFlow()

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            _postFeedState.update { it.copy(isLoading = true) }
            try {
                val snapshot = db.collection("posts")
                    .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
                    .get()
                    .await()
                val posts = snapshot.toObjects(Post::class.java)

                // Logika untuk mengelompokkan postingan berdasarkan bulan dan tahun
                val sdf = SimpleDateFormat("MMMM yyyy", Locale.US)
                val grouped = posts.groupBy { post ->
                    sdf.format(Date(post.timestamp))
                }

                _postFeedState.update { it.copy(isLoading = false, groupedPosts = grouped) }
            } catch (e: Exception) {
                _postFeedState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun createPost(imageUrl: String, title: String, description: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val user = auth.currentUser ?: throw Exception("Pengguna tidak login")
                val userProfile = db.collection("users").document(user.uid).get().await()
                val username = userProfile.getString("fullname") ?: "Pengguna Flawless"

                val post = Post(
                    id = UUID.randomUUID().toString(),
                    userId = user.uid,
                    username = username,
                    imageUrl = imageUrl,
                    title = title,
                    description = description,
                    timestamp = System.currentTimeMillis()
                )

                db.collection("posts").document(post.id).set(post).await()
                fetchPosts() // Refresh data setelah membuat post baru
                onComplete(true)
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete(false)
            }
        }
    }

    fun toggleFavorite(postId: String, isFavorited: Boolean) {
        viewModelScope.launch {
            val userId = auth.currentUser?.uid ?: return@launch
            val postRef = db.collection("posts").document(postId)
            try {
                val updateTask = if (isFavorited) {
                    postRef.update("favoritedBy", FieldValue.arrayRemove(userId))
                } else {
                    postRef.update("favoritedBy", FieldValue.arrayUnion(userId))
                }
                updateTask.await()
                fetchPosts() // Refresh data untuk update UI
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            try {
                db.collection("posts").document(postId).delete().await()
                fetchPosts() // Refresh data setelah menghapus
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun updatePost(postId: String, newTitle: String, newDescription: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                db.collection("posts").document(postId)
                    .update(
                        mapOf(
                            "title" to newTitle,
                            "description" to newDescription
                        )
                    ).await()
                fetchPosts() // Refresh data setelah update
                onComplete(true)
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete(false)
            }
        }
    }
}