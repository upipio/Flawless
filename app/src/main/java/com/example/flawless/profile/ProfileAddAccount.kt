package com.example.flawless.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAddAccount( // 1. Mengganti nama fungsi agar konsisten
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // 2. Menggunakan Column sebagai layout utama, bukan Box
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // --- Top Bar ---
        CenterAlignedTopAppBar(
            title = {
                Text("Add Account", color = Color(0xfffa9a97))
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black // Warna ikon hitam
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
        )
        Divider(color = Color.Gray.copy(alpha = 0.3f))

        // --- Konten Utama ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // 3. Opsi Akun yang bisa diklik
            AccountOptionItem(
                icon = painterResource(id = R.drawable.mdi_account_plus_outline),
                title = "Existing Account",
                subtitle = "Add an account you already have",
                onClick = { /* TODO: Logika untuk menambah akun yang sudah ada */ }
            )

            Spacer(modifier = Modifier.height(32.dp))

            AccountOptionItem(
                icon = painterResource(id = R.drawable.mdi_account_circle),
                title = "New Account",
                subtitle = "Create a new Flawless account",
                onClick = { /* TODO: Logika untuk membuat akun baru */ }
            )
        }

        // 4. Mendorong Bottom Bar ke bawah
        Spacer(modifier = Modifier.weight(1f))

        // --- Bottom Bar ---
        /*Column {
            Divider(color = Color.Gray.copy(alpha = 0.2f))
            BottomAppBar(
                containerColor = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings Icon",
                        tint = Color(0xff589591)
                    )
                }
            }
        }*/
    }
}

// 5. Composable terpisah untuk setiap item opsi agar kode rapi
@Composable
private fun AccountOptionItem(
    icon: Painter,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Latar belakang ikon
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color(0xff589591).copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = title,
                modifier = Modifier.size(32.dp),
                tint = Color(0xff589591)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Kolom untuk teks
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileAddAccountPreview() {
    ProfileAddAccount(navController = rememberNavController())
}