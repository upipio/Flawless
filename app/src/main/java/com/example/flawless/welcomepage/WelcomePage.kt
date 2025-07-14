package com.example.flawless.welcomepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize() // Menggunakan fillMaxSize agar responsif
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Column untuk menata semua elemen secara vertikal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 64.dp), // Padding untuk seluruh layar
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bagian Header
            Text(
                text = "Welcome to Photo Diary!",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Preserve your precious moments in pictures and stories.\nLet’s start your memory adventure today.",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )

            // Spacer untuk mendorong konten ke tengah dan bawah
            Spacer(modifier = Modifier.weight(1f))

            // Ilustrasi
            Image(
                painter = painterResource(id = R.drawable.photos_bro),
                contentDescription = "Illustration of Photos",
                modifier = Modifier
                    .fillMaxWidth(0.85f) // Mengisi 85% lebar
                    .aspectRatio(1f)   // Menjaga rasio gambar
            )

            Spacer(modifier = Modifier.weight(1f))

            // Bagian Tombol
            Button(
                onClick = {
                    navController.navigate(AppDestinations.SIGN_UP_PAGE)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                // Mengambil warna dari tema, gunakan default
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Create Account",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate(AppDestinations.LOGIN_PAGE)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Text(
                    text = "Log In",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomePagePreview() {
    MaterialTheme {
        WelcomePage(navController = rememberNavController(), modifier = Modifier.fillMaxSize())
    }
}