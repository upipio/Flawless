package com.example.flawless.homepage

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.core.SupabaseClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.UUID

class StorageViewModel : ViewModel() {

    // Buat client OkHttp
    private val client = OkHttpClient()

    fun uploadImage(
        context: Context,
        imageUri: Uri,
        bucketName: String = "post-images",
        onComplete: (success: Boolean, imageUrl: String?, message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                // Dapatkan byte dari file gambar
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val bytes = inputStream?.readBytes()
                inputStream?.close()

                if (bytes == null) {
                    onComplete(false, null, "Gagal membaca file dari URI.")
                    return@launch
                }

                // Buat nama file unik dan URL endpoint
                val fileName = "${UUID.randomUUID()}.jpg"
                val url = "${SupabaseClient.SUPABASE_URL}/storage/v1/object/$bucketName/$fileName"

                // Buat request body dengan byte gambar
                val requestBody = bytes.toRequestBody("image/jpeg".toMediaType())

                // Bangun request HTTP PUT dengan header yang diperlukan
                val request = Request.Builder()
                    .url(url)
                    .put(requestBody) // Gunakan PUT untuk mengunggah
                    .addHeader("apikey", SupabaseClient.SUPABASE_ANON_KEY)
                    .addHeader("Authorization", "Bearer ${SupabaseClient.SUPABASE_ANON_KEY}")
                    .addHeader("x-upsert", "true") // Otomatis buat file jika belum ada
                    .build()

                // Jalankan request di background thread
                withContext(Dispatchers.IO) {
                    client.newCall(request).execute().use { response ->
                        if (response.isSuccessful) {
                            // Jika berhasil, buat URL publik secara manual
                            val publicUrl = "${SupabaseClient.SUPABASE_URL}/storage/v1/object/public/$bucketName/$fileName"
                            onComplete(true, publicUrl, "Unggah berhasil!")
                        } else {
                            // Jika gagal, kirim pesan error
                            val errorBody = response.body?.string()
                            onComplete(false, null, "Gagal: ${response.code} - $errorBody")
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete(false, null, e.message ?: "Terjadi error yang tidak diketahui.")
            }
        }
    }
}