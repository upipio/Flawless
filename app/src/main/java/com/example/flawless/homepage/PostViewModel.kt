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
import java.util.UUID

// Perbarui data class Post
data class Post(
    val id: String = "",
    val userId: String = "",
    val username: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val description: String = "",
    val timestamp: Long = 0L,
    // Tambahkan field baru untuk menyimpan daftar ID pengguna yang me-like
    val favoritedBy: List<String> = emptyList()
)

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
                _postFeedState.update { it.copy(isLoading = false, posts = posts) }
            } catch (e: Exception) {
                _postFeedState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun createPost(imageUrl: String, title: String, description: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val user = auth.currentUser ?: throw Exception("Pengguna tidak login")
                // Ambil data profil terbaru untuk mendapatkan nama
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
                onComplete(true)
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete(false)
            }
        }
    }

    // --- FUNGSI BARU UNTUK FAVORIT ---
    fun toggleFavorite(postId: String, isFavorited: Boolean) {
        viewModelScope.launch {
            val userId = auth.currentUser?.uid ?: return@launch
            val postRef = db.collection("posts").document(postId)

            try {
                if (isFavorited) {
                    // Jika sudah difavoritkan, hapus ID pengguna dari array
                    postRef.update("favoritedBy", FieldValue.arrayRemove(userId)).await()
                } else {
                    // Jika belum, tambahkan ID pengguna ke array
                    postRef.update("favoritedBy", FieldValue.arrayUnion(userId)).await()
                }
                // Ambil ulang data untuk memperbarui UI
                fetchPosts()
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle error jika perlu
            }
        }
    }

    // --- FUNGSI BARU UNTUK HAPUS ---
    fun deletePost(postId: String) {
        viewModelScope.launch {
            try {
                db.collection("posts").document(postId).delete().await()
                // Ambil ulang data untuk memperbarui UI
                fetchPosts()
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle error jika perlu
            }
        }
    }
}