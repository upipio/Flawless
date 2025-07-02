package com.example.flawless.welcomepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.AppDestinations
import com.example.flawless.R

@Composable
fun WelcomePage(
    navController: NavController, // Tambahkan NavController sebagai parameter
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier // Gunakan modifier yang diteruskan
            .requiredWidth(width = 412.dp) // Pertimbangkan menggunakan .fillMaxSize() jika ini adalah root screen
            .requiredHeight(height = 917.dp) // Sama seperti di atas
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image", // Deskripsi yang lebih baik
            modifier = Modifier.fillMaxSize(), // Biarkan gambar latar mengisi Box
            contentScale = ContentScale.Crop // Agar gambar mengisi tanpa distorsi
        )

        // --- Header Text ---
        Text(
            text = "Welcome to Photo Diary!",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold), // Gunakan MaterialTheme
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 64.dp, y = 64.dp)
        )
        Text(
            text = "Preserve your precious moments in pictures and stories.\nLet’s start your memory adventure today.",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium), // Gunakan MaterialTheme
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp, y = 122.dp)
                .requiredWidth(width = 388.dp)
        )

        // --- Decorative Image Vector ---
        Image(
            painter = painterResource(id = R.drawable.vector_1),
            contentDescription = "Decorative Vector",
            alpha = 0.6f,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 9.dp, y = 211.dp)
                .requiredSize(size = 403.dp)
                .border(border = BorderStroke(1.dp, Color.White))
        )
        Image(
            painter = painterResource(id = R.drawable.photos_bro),
            contentDescription = "Illustration of Photos",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 29.dp, y = 236.dp)
                .requiredSize(size = 365.dp)
        )

        // --- Create Account Button ---
        // Kita akan menggabungkan Image dan Text dalam Box agar clickable bersamaan
        Box(
            contentAlignment = Alignment.Center, // Pusatkan Text di dalam Box ini
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 80.dp, y = 647.dp)
                .requiredWidth(width = 253.dp)
                .requiredHeight(height = 50.dp)
                .clip(shape = RoundedCornerShape(50.dp)) // Clip sebelum shadow dan background
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(50.dp)) // Shadow yang lebih standar
                .background(
                    color = MaterialTheme.colorScheme.primary, // Gunakan warna dari tema jika memungkinkan
                    shape = RoundedCornerShape(50.dp)
                )
                .clickable { // JADIKAN CLICKABLE
                    navController.navigate(AppDestinations.SIGN_UP_PAGE) {
                        // Opsi: jika Anda ingin membersihkan WelcomePage dari backstack
                        popUpTo(AppDestinations.WELCOME_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
        ) {
            // Gambar Rectangle_2 sekarang menjadi latar belakang Box di atas
            // Jika Rectangle_2 adalah gambar spesifik dan bukan hanya warna,
            // Anda bisa menempatkannya sebagai Image di dalam Box ini, di belakang Text.
            // Untuk contoh ini, saya asumsikan itu adalah warna latar.

            Text(
                text = "Create Account",
                color = MaterialTheme.colorScheme.onPrimary, // Warna teks yang kontras dengan primary
                style = MaterialTheme.typography.labelLarge, // Gaya teks yang sesuai untuk tombol
            )
        }

        // --- Log In Button ---
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 95.dp, y = 715.dp)
                .requiredWidth(width = 220.dp)
                .requiredHeight(height = 50.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .border(
                    border = BorderStroke(2.dp, Color.White), // Border tetap
                    shape = RoundedCornerShape(50.dp)
                )
                .clickable { // JADIKAN CLICKABLE
                    navController.navigate(AppDestinations.LOGIN_PAGE) {
                        // Opsi: jika Anda ingin membersihkan WelcomePage dari backstack
                        popUpTo(AppDestinations.WELCOME_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
        ) {
            // Sama seperti di atas, Rectangle_3 bisa jadi latar atau border
            // Di sini border sudah dihandle di atas.
            Text(
                text = "Log In",
                color = Color.White, // Warna teks tetap putih sesuai desain
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Preview(widthDp = 412, heightDp = 917, showBackground = true)
@Composable
private fun WelcomePagePreview() {
    // Untuk preview, kita bisa membuat NavController palsu atau menggunakan rememberNavController
    // jika WelcomePage tidak melakukan navigasi kompleks di preview itu sendiri.
    val navController = rememberNavController()
    // Pastikan tema juga diterapkan di preview untuk gaya yang konsisten
    MaterialTheme { // Atau FlawlessTheme jika itu nama tema Anda
        WelcomePage(navController = navController, modifier = Modifier.fillMaxSize())
    }
}