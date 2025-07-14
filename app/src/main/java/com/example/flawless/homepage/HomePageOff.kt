package com.example.flawless.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.AppDestinations
import com.example.flawless.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageOff(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.flawless),
                            contentDescription = "Logo",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color(0xff84bdb9), fontWeight = FontWeight.Bold)) { append("Photo ") }
                                withStyle(style = SpanStyle(color = Color(0xfffa9a97), fontWeight = FontWeight.Bold)) { append("Diary") }
                            },
                            fontSize = 20.sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(AppDestinations.HOME_PAGE_OFF)}) {
                        Icon(
                            painter = painterResource(id = R.drawable.frame_calendar),
                            contentDescription = "Calendar View",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.shadow(elevation = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate(AppDestinations.HOME_PAGE_1) }) {
                        Icon(Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(30.dp), tint = Color(0xff589591))
                    }
                    IconButton(onClick = { navController.navigate(AppDestinations.CREATE_PAGE) }) {
                        Icon(Icons.Outlined.AddCircleOutline, contentDescription = "Upload", modifier = Modifier.size(35.dp), tint = Color.Gray)
                    }
                    IconButton(onClick = { navController.navigate(AppDestinations.PROFILE_PAGE) }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile", modifier = Modifier.size(30.dp), tint = Color(0xff589591))
                    }
                }
            }
            Divider(color = Color(0xff589591).copy(alpha = 0.5f), thickness = 2.dp)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) //
                .background(Color.White)
        ) {
            Divider(color = Color(0xff4F4F4F).copy(alpha = 0.5f), thickness = 2.dp)

            // Menggunakan daftar bulan dinamis
            val months = getMonthsList()

            LazyColumn(
                modifier = Modifier.fillMaxSize() // LazyColumn mengisi sisa ruang Column
            ) {
                items(months) { month ->
                    MonthItem(
                        month = month,
                        onClick = {
                            navController.navigate(AppDestinations.HOME_PAGE_1)
                        }
                    )
                }
            }
        }
    }
}

// untuk membuat daftar bulan dinamis
private fun getMonthsList(): List<String> {
    val months = mutableListOf<String>()
    val calendar = Calendar.getInstance() // Mendapatkan waktu saat ini
    val sdf = SimpleDateFormat("MMMM yyyy", Locale.US) // Format: "July 2025"

    // Membuat daftar 12 bulan ke belakang dari sekarang
    repeat(12) {
        months.add(sdf.format(calendar.time))
        calendar.add(Calendar.MONTH, -1) // Mundur satu bulan
    }
    return months
}

@Composable
fun MonthItem(month: String, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable(onClick = onClick)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowtop),
                contentDescription = "Go to month",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = month,
                color = Color(0xff737373),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePageOffPreview() {
    HomePageOff(navController = rememberNavController())
}