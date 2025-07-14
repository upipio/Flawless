package com.example.flawless.homepage

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.core.SupabaseClient
import kotlinx.coroutines.launch
import java.util.UUID

class StorageViewModel : ViewModel() {

    private val storage = SupabaseClient.storage

    // Fungsi untuk mengunggah gambar
    fun uploadImage(
        context: Context,
        imageUri: Uri,
        bucketName: String = "post-images", // Nama bucket yang Anda buat
        onComplete: (success: Boolean, imageUrl: String?, message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                // Baca data gambar dari URI
                val contentResolver = context.contentResolver
                val inputStream = contentResolver.openInputStream(imageUri)
                val bytes = inputStream?.readBytes()
                inputStream?.close()

                if (bytes == null) {
                    onComplete(false, null, "Failed to read image file.")
                    return@launch
                }

                // Buat nama file yang unik menggunakan UUID
                val fileName = "${UUID.randomUUID()}"

                // Unggah byte gambar ke Supabase Storage
                storage.from(bucketName).upload(fileName, bytes)

                // Dapatkan URL publik dari gambar yang baru diunggah
                val publicUrl = storage.from(bucketName).publicUrl(fileName)

                onComplete(true, publicUrl, "Upload successful!")

            } catch (e: Exception) {
                onComplete(false, null, e.message)
            }
        }
    }
}