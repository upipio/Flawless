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

// State untuk Login
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

    // State untuk Login
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    //fungsi ini berada di dalam file: app/src/main/java/com/example/flawless/welcomepage/AuthViewModel.kt
    fun createUser(email: String, password: String, fullname: String) {
    //input email dan password diambil dari parameter
    //yang dipanggil dari UI (SignUpPage.kt)
        viewModelScope.launch {
            //set state menjadi loading
            _signUpState.update { it.copy(isLoading = true, error = null) }
            try {
                //memanggil metode createUserWithEmailAndPassword dari Firebase
                val authResult = auth.createUserWithEmailAndPassword(email, password).await()
                val user = authResult.user

                //jika berhasil, simpan data nama ke Firestore
                user?.uid?.let { userId ->
                    val userProfile = hashMapOf(
                        "uid" to userId,
                        "fullname" to fullname,
                        "email" to email,
                        "createdAt" to System.currentTimeMillis()
                    )
                    db.collection("users").document(userId).set(userProfile).await()
                }
                //menangani jika registrasi berhasil
                _signUpState.update { it.copy(isLoading = false, isSuccess = true) }
            } catch (e: Exception) {
                //menangani jika terjadi error
                //pengecekan spesifik untuk AuthUser Exception di sini
                //Firebase Auth sudah memberikan pesan error yang jelas scara otomatis
                //seperti "The email address is already in use by another account" yang ada didalam e.message
                _signUpState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    // Fungsi untuk Login
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

    // Fungsi untuk mereset state login
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