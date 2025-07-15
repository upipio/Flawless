package com.example.flawless.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.homepage.Post // Import data class Post
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

data class UserProfile(
    val fullname: String = "",
    val email: String = "",
    val bio: String = "New Memories, New Life. Preserving amazing moments forever!!!"
)

// State baru yang menggabungkan semua data untuk halaman profil
data class ProfileState(
    val isLoading: Boolean = false,
    val userProfile: UserProfile? = null,
    val favoritePosts: List<Post> = emptyList(), // Daftar postingan favorit
    val error: String? = null
)

class ProfileViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val db = Firebase.firestore

    private val _profileState = MutableStateFlow(ProfileState())
    val profileState = _profileState.asStateFlow()

    init {
        // Panggil fungsi utama untuk memuat semua data profil
        loadProfileData()
    }

    fun loadProfileData() {
        viewModelScope.launch {
            _profileState.update { it.copy(isLoading = true) }
            val userId = auth.currentUser?.uid
            if (userId == null) {
                _profileState.update { it.copy(isLoading = false, error = "Pengguna tidak login.") }
                return@launch
            }

            try {
                // 1. Ambil data profil pengguna (seperti sebelumnya)
                val profileDoc = db.collection("users").document(userId).get().await()
                val userProfile = profileDoc.toObject(UserProfile::class.java)

                // 2. Ambil postingan yang difavoritkan
                val favoritePostsSnapshot = db.collection("posts")
                    .whereArrayContains("favoritedBy", userId) // Query utama untuk favorit
                    .get()
                    .await()
                val favoritePosts = favoritePostsSnapshot.toObjects(Post::class.java)

                // 3. Update state dengan semua data baru
                _profileState.update {
                    it.copy(
                        isLoading = false,
                        userProfile = userProfile,
                        favoritePosts = favoritePosts
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _profileState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}