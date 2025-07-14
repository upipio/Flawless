package com.example.flawless.core

import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

object SupabaseClient {
    private const val SUPABASE_URL = "https://wvxodaryzootejbinvje.supabase.co"
    private const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Ind2eG9kYXJ5em9vdGVqYmludmplIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTI0ODA4MzYsImV4cCI6MjA2ODA1NjgzNn0.Ssife51S9iFzcc3MrCvTl3z0x5zczbWogMMgHTPhLsM"
    const val SUPABASE_PUBLIC_URL = "$SUPABASE_URL/storage/v1/object/public"

    private val okHttpClient = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("apikey", SUPABASE_ANON_KEY)
                .addHeader("Authorization", "Bearer $SUPABASE_ANON_KEY")
                .build()
            chain.proceed(request)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("$SUPABASE_URL/storage/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val storageService: SupabaseStorageService = retrofit.create(SupabaseStorageService::class.java)
}

interface SupabaseStorageService {
    @PUT("object/{bucket}/{filename}")
    @Headers("x-upsert: true")
    suspend fun uploadFile(
        @Path("bucket") bucket: String,
        @Path("filename") filename: String,
        @Body file: RequestBody
    ): retrofit2.Response<Unit>
}
