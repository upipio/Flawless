package com.example.flawless.homepage

import com.example.flawless.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

// Model untuk satu postingan/foto
data class DiaryPost(
    val id: Int,
    val imageUrl: Int,
    val description: String,
    val postDate: Date = Date()
)

// Model untuk album bulanan yang berisi banyak postingan
data class MonthlyAlbum(
    val month: String,
    val posts: List<DiaryPost>
)

// --- FUNGSI DATA YANG SUDAH DIPERBAIKI TOTAL ---
fun generateFixedHomePageData(): List<MonthlyAlbum> {
    val albums = mutableListOf<MonthlyAlbum>()
    val calendar = Calendar.getInstance()
    val sdf = SimpleDateFormat("MMMM yyyy", Locale.US)

    // Data spesifik untuk Juli 2025
    val julyPosts = listOf(
        DiaryPost(1, R.drawable.gambar_kurban_place_holder, "Pengalaman pertama jadi panitia kurban di hari raya Idul Adha di tahun 2025. Alhamdulillah di kasih kesempatan buat jadi panitia kurban, senang rasanya bisa membantu di hari besar seperti ini ditambah dapet daging tambahan karna jadi panitia wkwkwk.\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        DiaryPost(2, R.drawable.gambar_sapi_place_holder, "Sapi kurban tahun ini terlihat sangat sehat dan besar."),
        DiaryPost(3, R.drawable.gambar_cewe_dan_kucing_place_holder, "Si embul narsis sekali sekarang")
    )

    // Data spesifik untuk Juni 2025
    val junePosts = listOf(
        DiaryPost(4, R.drawable.gambar_punggung_place_holder, "Belajar gambar lagi!, hari ini selesai 1 jam"),
        DiaryPost(5, R.drawable.sleeping, "Melihatnya tidur pulas adalah kebahagiaan."),
        DiaryPost(6, R.drawable.ontwitter1, "Menemukan ilustrasi yang sangat inspiratif.")
    )

    // Membuat daftar untuk 12 bulan terakhir
    repeat(12) {
        val monthName = sdf.format(calendar.time)
        when (monthName) {
            "July 2025" -> albums.add(MonthlyAlbum(month = monthName, posts = julyPosts))
            "June 2025" -> albums.add(MonthlyAlbum(month = monthName, posts = junePosts))
            else -> albums.add(MonthlyAlbum(month = monthName, posts = emptyList())) // Bulan lainnya KOSONG
        }
        calendar.add(Calendar.MONTH, -1)
    }

    return albums
}