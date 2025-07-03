package com.example.flawless.welcomepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.AppDestinations
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController, // 1. NavController
    modifier: Modifier = Modifier
) {
    // 2. State untuk menyimpan input dan status UI
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 3. Tombol Back
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 24.dp)
                .clip(RoundedCornerShape(50))
                .clickable { navController.popBackStack() }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Back", color = Color.White, fontSize = 16.sp)
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.7f), // Mengisi 70% dari bawah
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()) // Dibuat bisa scroll
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(52.dp))

                Text(
                    text = "Welcome Back!",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Step Back Into Your Memories!\nYour path is right here.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                // 4. Form Input
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Your Email") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xff84bdb9),
                        unfocusedIndicatorColor = Color(0xff828282)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Your Password") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xff84bdb9),
                        unfocusedIndicatorColor = Color(0xff828282)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // 5. Checkbox dan Forgot Password
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { rememberMe = !rememberMe }
                    ) {
                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it },
                            colors = CheckboxDefaults.colors(checkedColor = Color(0xff84bdb9))
                        )
                        Text("Remember me", style = MaterialTheme.typography.bodySmall, color = Color.Black)
                    }
                    Text(
                        text = "Forgot Password?",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        modifier = Modifier.clickable { /* TODO: Logika Lupa Password */ }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Tombol Login Fungsional
                Button(
                    onClick = {
                        // TODO: Tambahkan validasi login dengan data dari Firebase/server
                        // Untuk sekarang, kita langsung navigasi ke home
                        navController.navigate(AppDestinations.HOME_PAGE) { //Ganti dengan homepage
                            // Menghapus semua halaman sebelumnya dari backstack
                            popUpTo(0) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff84bdb9))
                ) {
                    Text(text = "Log In", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(35.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Divider(color = Color(0xff84bdb9), modifier = Modifier.weight(1f))
                    Text(
                        text = "Sign in with",
                        color = Color(0xff84bdb9),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Divider(color = Color(0xff84bdb9), modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(15.dp))

                // 7. Tombol Social Media
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { /* TODO: Logika Sign In Google */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Sign in with Google",
                            modifier = Modifier.size(55.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    IconButton(onClick = { /* TODO: Logika Sign In Facebook */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Sign in with Facebook",
                            modifier = Modifier.size(55.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    // butuh NavController untuk preview, gunakan rememberNavController()
    LoginPage(navController = rememberNavController())
}