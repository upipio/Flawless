package com.example.flawless.core

import io.supabase.kt.Supabase
import io.supabase.kt.storage.storage

object SupabaseClient {

    // GANTI DENGAN URL DAN KUNCI ANDA
    private const val SUPABASE_URL = "https://wvxodaryzootejbinvje.supabase.co"
    private const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Ind2eG9kYXJ5em9vdGVqYmludmplIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTI0ODA4MzYsImV4cCI6MjA2ODA1NjgzNn0.Ssife51S9iFzcc3MrCvTl3z0x5zczbWogMMgHTPhLsM"

    val client = Supabase.create(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_ANON_KEY
    )

    // Shortcut untuk mengakses storage bucket
    val storage
        get() = client.storage
}