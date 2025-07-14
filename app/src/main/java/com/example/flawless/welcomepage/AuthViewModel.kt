package com.example.flawless.welcomepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    // Fungsi untuk membuat pengguna baru dengan email dan password
    fun createUser(email: String, password: String, onComplete: (success: Boolean, message: String?) -> Unit) {
        viewModelScope.launch {
            try {
                // Memanggil fungsi createUserWithEmailAndPassword dari Firebase
                auth.createUserWithEmailAndPassword(email, password).await()
                // Jika berhasil, kirim status sukses
                onComplete(true, null)
            } catch (e: Exception) {
                // Jika gagal, kirim status gagal beserta pesan errornya
                onComplete(false, e.message)
            }
        }
    }

    // ... di dalam class AuthViewModel

    // Fungsi untuk login dengan Google
    fun signInWithGoogle(idToken: String, onComplete: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val credential = GoogleAuthProvider.getCredential(idToken, null)
                auth.signInWithCredential(credential).await()
                onComplete(true, null)
            } catch (e: Exception) {
                onComplete(false, e.message)
            }
        }
    }

    // (Nanti kita akan tambahkan fungsi login di sini)
}