package com.example.flawless.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSetting(
    navController: NavController,
    modifier: Modifier = Modifier,
    settingsViewModel: ProfileSettingsViewModel = viewModel()
) {
    val state by settingsViewModel.settingsState.collectAsState()
    val context = LocalContext.current

    // State untuk menampung input dari pengguna
    var fullname by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    // LaunchedEffect untuk mengisi form saat data dari ViewModel tersedia
    LaunchedEffect(state) {
        if (fullname.isEmpty() && state.fullname.isNotEmpty()) {
            fullname = state.fullname
        }
        if (bio.isEmpty() && state.bio.isNotEmpty()) {
            bio = state.bio
        }
        if(state.isSuccess) {
            Toast.makeText(context, "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }
        if(state.error != null) {
            Toast.makeText(context, "Error: ${state.error}", Toast.LENGTH_LONG).show()
        }
    }

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
        if (state.isLoading && fullname.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = painterResource(id = R.drawable.mdi_account_circle),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .clickable { /* TODO: Logika ganti foto */ }
                )
                Text(
                    text = "+ Edit Photo Profile",
                    color = Color(0xff84bdb9),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable { /* TODO: Logika ganti foto */ }
                )

                Spacer(modifier = Modifier.height(32.dp))

                SettingTextField(
                    label = "Fullname",
                    value = fullname,
                    onValueChange = { fullname = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // TextField untuk email, tapi nonaktif
                SettingTextField(
                    label = "Email",
                    value = state.email,
                    onValueChange = {},
                    enabled = false // Email tidak bisa diubah
                )

                Spacer(modifier = Modifier.height(16.dp))

                SettingTextField(
                    label = "Bio",
                    value = bio,
                    onValueChange = { bio = it },
                    modifier = Modifier.height(120.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

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
                        onClick = { settingsViewModel.saveProfile(fullname, bio) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff589591)),
                        enabled = !state.isLoading
                    ) {
                        if (state.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.White)
                        } else {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true // Tambahkan parameter enabled
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
            enabled = enabled, // Gunakan parameter enabled
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.3f),
                unfocusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.3f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.DarkGray,
                unfocusedTextColor = Color.DarkGray,
                // Warna saat nonaktif
                disabledTextColor = Color.Gray,
                disabledContainerColor = Color.LightGray.copy(alpha = 0.2f)
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