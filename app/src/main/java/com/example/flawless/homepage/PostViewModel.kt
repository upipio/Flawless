package com.example.flawless.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID

// Data class untuk merepresentasikan satu postingan
data class Post(
    val id: String = "",
    val userId: String = "",
    val username: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val description: String = "",
    val timestamp: Long = 0L
)

// State untuk daftar postingan di beranda
data class PostFeedState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)

class PostViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val auth = Firebase.auth

    private val _postFeedState = MutableStateFlow(PostFeedState())
    val postFeedState = _postFeedState.asStateFlow()

    init {
        // Langsung ambil data postingan saat ViewModel dibuat
        fetchPosts()
    }

    // Fungsi untuk mengambil semua postingan
    fun fetchPosts() {
        viewModelScope.launch {
            _postFeedState.update { it.copy(isLoading = true) }
            try {
                val snapshot = db.collection("posts")
                    .orderBy("timestamp", com.google.firebase.firestore.Query.Direction.DESCENDING)
                    .get()
                    .await()
                val posts = snapshot.toObjects(Post::class.java)
                _postFeedState.update { it.copy(isLoading = false, posts = posts) }
            } catch (e: Exception) {
                _postFeedState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    // Fungsi untuk membuat postingan baru
    fun createPost(imageUrl: String, title: String, description: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val user = auth.currentUser ?: throw Exception("Pengguna tidak login")
                val userId = user.uid
                val username = user.displayName ?: "Pengguna Flawless" // Ambil nama dari profil auth

                val post = Post(
                    id = UUID.randomUUID().toString(),
                    userId = userId,
                    username = username,
                    imageUrl = imageUrl,
                    title = title,
                    description = description,
                    timestamp = System.currentTimeMillis()
                )

                db.collection("posts").document(post.id).set(post).await()
                onComplete(true)
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete(false)
            }
        }
    }
}