package com.example.flawless.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSetting(
    navController: NavController, // 1. Tambahkan NavController
    modifier: Modifier = Modifier
) {
    // State untuk menyimpan input dari pengguna
    var fullname by remember { mutableStateOf("FULLNAME") }
    var email by remember { mutableStateOf("email@gmail.com") }
    var bio by remember { mutableStateOf("New Memories, New Life. Preserving amazing moments forever!!!") }

    // 2. Menggunakan Scaffold untuk struktur halaman yang benar
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text("Profile Setting", color = Color(0xfffa9a97))
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
                )
                Divider(color = Color.Gray.copy(alpha = 0.3f))
            }
        },
    ) { paddingValues ->
        // 3. Menggunakan Column agar konten bisa di-scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp), // Padding untuk sisi kiri dan kanan
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // 4. Bagian Foto Profil yang bisa diklik
            Image(
                painter = painterResource(id = R.drawable.mdi_account_circle),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .clickable { /*  Logika ganti foto */ }
            )
            Text(
                text = "+ Edit Photo Profile",
                color = Color(0xff84bdb9),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { /*  Logika ganti foto */ }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 5. Input Fields menggunakan composable terpisah
            SettingTextField(
                label = "Fullname",
                value = fullname,
                onValueChange = { fullname = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SettingTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SettingTextField(
                label = "Bio",
                value = bio,
                onValueChange = { bio = it },
                modifier = Modifier.height(120.dp) // Lebih tinggi untuk bio
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 6. Tombol Cancel dan Save dengan posisi yang benar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF828282))
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Logika Save */ navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff589591))
                ) {
                    Text("Save")
                }
            }
        }
    }
}

// 7. Composable terpisah untuk TextField agar kode lebih rapi
@Composable
private fun SettingTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color(0xff589591),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.3f),
                unfocusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.3f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.DarkGray,
                unfocusedTextColor = Color.DarkGray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileSettingPreview() {
    // Jangan lupa sertakan NavController di preview
    ProfileSetting(navController = rememberNavController())
}