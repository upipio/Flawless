package com.example.flawless.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

// State untuk halaman detail
data class PostDetailState(
    val isLoading: Boolean = false,
    val post: Post? = null,
    val error: String? = null
)

class DetailPostViewModel : ViewModel() {
    private val db = Firebase.firestore

    private val _postDetailState = MutableStateFlow(PostDetailState())
    val postDetailState = _postDetailState.asStateFlow()

    // Fungsi untuk mengambil detail satu post berdasarkan ID
    fun fetchPostById(postId: String) {
        if (postId.isBlank()) {
            _postDetailState.update { it.copy(error = "Post ID tidak valid.") }
            return
        }

        viewModelScope.launch {
            _postDetailState.update { it.copy(isLoading = true) }
            try {
                val document = db.collection("posts").document(postId).get().await()
                if (document.exists()) {
                    val post = document.toObject(Post::class.java)
                    _postDetailState.update { it.copy(isLoading = false, post = post) }
                } else {
                    throw Exception("Postingan tidak ditemukan.")
                }
            } catch (e: Exception) {
                _postDetailState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}