package com.example.flawless.homepage

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.core.storage
import kotlinx.coroutines.launch
import java.util.UUID

class StorageViewModel : ViewModel() {

    fun uploadImage(
        context: Context,
        imageUri: Uri,
        bucketName: String = "post-images", // Pastikan bucket 'post-images' ada di Supabase
        onComplete: (success: Boolean, imageUrl: String?, message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                // 1. Dapatkan byte dari URI menggunakan ContentResolver
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val bytes = inputStream?.readBytes()
                inputStream?.close()

                if (bytes == null) {
                    onComplete(false, null, "Gagal membaca file dari URI.")
                    return@launch
                }

                // 2. Buat nama file yang unik
                val fileName = "${UUID.randomUUID()}.jpg"

                // 3. Unggah file menggunakan library Supabase
                storage.from(bucketName).upload(path = fileName, data = bytes, upsert = true)

                // 4. Dapatkan URL publik dari gambar yang diunggah
                val publicUrl = storage.from(bucketName).publicUrl(path = fileName)

                onComplete(true, publicUrl, "Berhasil mengunggah gambar.")

            } catch (e: Exception) {
                // Tangani error dengan lebih baik
                e.printStackTrace()
                onComplete(false, null, e.message ?: "Terjadi error yang tidak diketahui.")
            }
        }
    }
}