package com.example.flawless.homepage

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.core.SupabaseClient
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.UUID

class StorageViewModel : ViewModel() {

    private val storage = SupabaseClient.storageService

    // Fungsi untuk mengunggah gambar
    fun uploadImage(
        context: Context,
        imageUri: Uri,
        bucketName: String = "post-images",
        onComplete: (success: Boolean, imageUrl: String?, message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val bytes = inputStream?.readBytes()
                inputStream?.close()

                if (bytes == null) {
                    onComplete(false, null, "Gagal membaca file.")
                    return@launch
                }

                val fileName = "${UUID.randomUUID()}.jpg"
                val requestBody = bytes.toRequestBody("image/jpeg".toMediaTypeOrNull())

                val response = SupabaseClient.storageService.uploadFile(bucketName, fileName, requestBody)

                if (response.isSuccessful) {
                    val publicUrl = "${SupabaseClient.SUPABASE_PUBLIC_URL}/$bucketName/$fileName"
                    onComplete(true, publicUrl, "Berhasil upload")
                } else {
                    onComplete(false, null, "Gagal upload: ${response.code()}")
                }
            } catch (e: Exception) {
                onComplete(false, null, e.message ?: "Error tidak diketahui")
            }
        }
    }
}