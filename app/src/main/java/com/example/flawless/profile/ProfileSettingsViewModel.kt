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

// State untuk halaman pengaturan
data class SettingsState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null,
    val fullname: String = "",
    val email: String = "",
    val bio: String = ""
)

class ProfileSettingsViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val auth = Firebase.auth
    private val userId: String?
        get() = auth.currentUser?.uid

    private val _settingsState = MutableStateFlow(SettingsState())
    val settingsState = _settingsState.asStateFlow()

    init {
        loadInitialData()
    }

    // Mengambil data awal untuk ditampilkan di form
    private fun loadInitialData() {
        viewModelScope.launch {
            val currentUserId = userId ?: return@launch
            _settingsState.update { it.copy(isLoading = true) }
            try {
                val userDoc = db.collection("users").document(currentUserId).get().await()
                _settingsState.update {
                    it.copy(
                        isLoading = false,
                        fullname = userDoc.getString("fullname") ?: "",
                        email = userDoc.getString("email") ?: "",
                        bio = userDoc.getString("bio") ?: ""
                    )
                }
            } catch (e: Exception) {
                _settingsState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    // Menyimpan perubahan ke Firestore
    fun saveProfile(newFullname: String, newBio: String) {
        viewModelScope.launch {
            val currentUserId = userId ?: return@launch
            _settingsState.update { it.copy(isLoading = true) }
            try {
                val userDocRef = db.collection("users").document(currentUserId)
                userDocRef.update(
                    mapOf(
                        "fullname" to newFullname,
                        "bio" to newBio
                    )
                ).await()
                _settingsState.update { it.copy(isLoading = false, isSuccess = true) }
            } catch (e: Exception) {
                _settingsState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}