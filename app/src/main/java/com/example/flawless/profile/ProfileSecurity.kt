package com.example.flawless.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSecurity(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var twoFactorAuthEnabled by remember { mutableStateOf(false) }
    var googleSignInEnabled by remember { mutableStateOf(false) }

    // Menggunakan Column sebagai layout utama
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // TopBar dibuat manual di dalam Column
        CenterAlignedTopAppBar(
            title = {
                Text("Security", color = Color(0xfffa9a97))
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    // 2. Warna Ikon diubah menjadi Hitam
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
        )
        // Divider untuk TopBar tetap ada
        Divider(color = Color.Gray.copy(alpha = 0.3f))

        // Konten utama dengan padding
        Column(
            modifier = Modifier
                .fillMaxSize() // Mengisi sisa ruang
                .padding(24.dp) // Padding yang lebih besar untuk konten
        ) {
            Text(
                text = "Include additional security like enabling two-factor authentication and checking your connected devices list to keep your account, Pins, and boards safe.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            SecurityOption(
                title = "Two-factor authentication",
                checked = twoFactorAuthEnabled,
                onCheckedChange = { twoFactorAuthEnabled = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This action makes your account extra secure. In addition to your password, you will also need to enter a secret code that we send to your phone every time you log in.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Divider di antara konten dihapus

            SecurityOption(
                title = "Sign In with Google",
                checked = googleSignInEnabled,
                onCheckedChange = { googleSignInEnabled = it }
            )

            // Bottom bar tidak diperlukan lagi di sini
        }
    }
}

@Composable
private fun SecurityOption(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f),
            color = Color.Black // 4. Warna teks diubah menjadi Hitam
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xff589591),
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color.LightGray
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileSecurityPreview() {
    ProfileSecurity(navController = rememberNavController())
}