package com.example.flawless.welcomepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

// State untuk Sign Up
data class SignUpState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

// State BARU untuk Login
data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    // State untuk Sign Up
    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    // State BARU untuk Login
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()


    fun createUser(email: String, password: String, fullname: String) {
        viewModelScope.launch {
            _signUpState.update { it.copy(isLoading = true, error = null) }
            try {
                val authResult = auth.createUserWithEmailAndPassword(email, password).await()
                val user = authResult.user

                user?.uid?.let { userId ->
                    val userProfile = hashMapOf(
                        "uid" to userId,
                        "fullname" to fullname,
                        "email" to email,
                        "createdAt" to System.currentTimeMillis()
                    )
                    db.collection("users").document(userId).set(userProfile).await()
                }
                _signUpState.update { it.copy(isLoading = false, isSuccess = true) }
            } catch (e: Exception) {
                _signUpState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    // Fungsi BARU untuk Login
    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginState.update { it.copy(isLoading = true, error = null) }
            try {
                auth.signInWithEmailAndPassword(email, password).await()
                _loginState.update { it.copy(isLoading = false, isSuccess = true) }
            } catch (e: Exception) {
                _loginState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun resetSignUpState() {
        _signUpState.value = SignUpState()
    }

    // Fungsi BARU untuk mereset state login
    fun resetLoginState() {
        _loginState.value = LoginState()
    }

    // Ubah Password
    fun changePassword(newPassword: String, onComplete: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            val user = auth.currentUser
            if (user == null) {
                onComplete(false, "Pengguna tidak login.")
                return@launch
            }
            try {
                user.updatePassword(newPassword).await()
                onComplete(true, "Password berhasil diperbarui.")
            } catch (e: Exception) {
                onComplete(false, e.message)
            }
        }
    }
}