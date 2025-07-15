package com.example.flawless.homepage

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flawless.core.SupabaseClient // Pastikan ini tidak merah
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.UUID

class StorageViewModel : ViewModel() {

    private val client = OkHttpClient()

    // Kita ubah agar menggunakan State, sama seperti ViewModel lain
    private val _uploadState = MutableStateFlow(UploadState())
    val uploadState = _uploadState.asStateFlow()

    fun uploadImage(
        imageUri: Uri,
        context: Context, // Tambahkan context
        bucketName: String = "post-images"
    ) {
        viewModelScope.launch {
            _uploadState.update { it.copy(isLoading = true, error = null) }
            try {
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val bytes = inputStream?.readBytes()
                inputStream?.close()

                if (bytes == null) {
                    throw Exception("Gagal membaca file dari URI.")
                }

                val fileName = "${UUID.randomUUID()}.jpg"
                val url = "${SupabaseClient.SUPABASE_URL}/storage/v1/object/$bucketName/$fileName"
                val requestBody = bytes.toRequestBody("image/jpeg".toMediaType())

                val request = Request.Builder()
                    .url(url)
                    .put(requestBody)
                    .addHeader("apikey", SupabaseClient.SUPABASE_ANON_KEY)
                    .addHeader("Authorization", "Bearer ${SupabaseClient.SUPABASE_ANON_KEY}")
                    .addHeader("x-upsert", "true")
                    .build()

                withContext(Dispatchers.IO) {
                    client.newCall(request).execute().use { response ->
                        if (response.isSuccessful) {
                            val publicUrl = "${SupabaseClient.SUPABASE_URL}/storage/v1/object/public/$bucketName/$fileName"
                            _uploadState.update { it.copy(isLoading = false, isSuccess = true, imageUrl = publicUrl) }
                        } else {
                            throw Exception("Gagal: ${response.code} - ${response.body?.string()}")
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uploadState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun resetUploadState() {
        _uploadState.value = UploadState()
    }
}

// Data class untuk state upload (bisa ditaruh di sini atau file terpisah)
data class UploadState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val imageUrl: String? = null,
    val error: String? = null
)