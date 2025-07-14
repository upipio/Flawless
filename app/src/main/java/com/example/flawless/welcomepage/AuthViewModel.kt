package com.example.flawless.welcomepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    // 1. Tambahkan referensi ke Firestore
    private val db = Firebase.firestore

    // 2. Perbarui fungsi createUser untuk menerima `fullname`
    fun createUser(
        email: String,
        password: String,
        fullname: String, // <-- Parameter baru
        onComplete: (success: Boolean, message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                // Buat akun di Authentication
                val authResult = auth.createUserWithEmailAndPassword(email, password).await()
                val user = authResult.user

                // Jika akun berhasil dibuat, simpan nama lengkap ke Firestore
                user?.uid?.let { userId ->
                    val userProfile = hashMapOf(
                        "uid" to userId,
                        "fullname" to fullname,
                        "email" to email,
                        "createdAt" to System.currentTimeMillis() // Catat waktu pembuatan
                    )
                    // Simpan ke koleksi "users" dengan ID yang sama dengan ID autentikasi
                    db.collection("users").document(userId).set(userProfile).await()
                }

                onComplete(true, null)
            } catch (e: Exception) {
                onComplete(false, e.message)
            }
        }
    }

    fun loginUser(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password).await()
                onComplete(true, null)
            } catch (e: Exception) {
                onComplete(false, e.message)
            }
        }
    }
}