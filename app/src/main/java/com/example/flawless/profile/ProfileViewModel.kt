package com.example.flawless.profile

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

// Data class untuk menampung data profil dari Firestore
data class UserProfile(
    val fullname: String = "",
    val email: String = "",
    val bio: String = "New Memories, New Life. Preserving amazing moments forever!!!" // Bio default
)

// Data class untuk state UI halaman profil
data class ProfileState(
    val isLoading: Boolean = false,
    val userProfile: UserProfile? = null,
    val error: String? = null
)

class ProfileViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val db = Firebase.firestore

    private val _profileState = MutableStateFlow(ProfileState())
    val profileState = _profileState.asStateFlow()

    init {
        // Langsung panggil fungsi untuk mengambil data saat ViewModel dibuat
        fetchUserProfile()
    }

    private fun fetchUserProfile() {
        viewModelScope.launch {
            _profileState.update { it.copy(isLoading = true) }
            try {
                // 1. Dapatkan ID pengguna yang sedang login
                val userId = auth.currentUser?.uid
                if (userId == null) {
                    throw Exception("Pengguna tidak login.")
                }

                // 2. Ambil dokumen dari Firestore berdasarkan ID pengguna
                val documentSnapshot = db.collection("users").document(userId).get().await()

                if (documentSnapshot.exists()) {
                    // 3. Ubah dokumen menjadi objek UserProfile
                    val user = documentSnapshot.toObject(UserProfile::class.java)
                    _profileState.update { it.copy(isLoading = false, userProfile = user) }
                } else {
                    throw Exception("Data profil tidak ditemukan.")
                }

            } catch (e: Exception) {
                _profileState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}