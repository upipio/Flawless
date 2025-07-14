package com.example.flawless.homepage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.R
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailPost(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // menggunakan data pertama dari album pertama sebagai contoh
    // Nanti ini akan diganti dengan data yang dilempar dari halaman sebelumnya
    val album = remember { generateFixedHomePageData().first { it.posts.isNotEmpty() } }
    val pagerState = rememberPagerState(pageCount = { album.posts.size })


    // Menggunakan Column sebagai dasar dengan TopAppBar
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()) // Membuat seluruh halaman bisa di-scroll
    ) {
        // HEADER

        // Tombol Back di paling atas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text("Back", style = MaterialTheme.typography.titleMedium, color = Color(0xFFFA9A97))
        }
        Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 2.dp)
        //Spacer(modifier = Modifier.height(8.dp))

        // Baris Judul dan Menu Titik Tiga
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), //start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Mendorong judul ke kiri & menu ke kanan
        ) {
            val currentPost = album.posts[pagerState.currentPage]
            val title = currentPost.description.split(" ").take(5).joinToString(" ")

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f),// Membuat teks fleksibel
                color = Color.Black
            )

            var menuExpanded by remember { mutableStateOf(false) }
            Box {
                IconButton(onClick = { menuExpanded = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.three_dot_vertical),
                        contentDescription = "More options",
                        modifier = Modifier.size(18.dp),
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false }
                ) {
                    DropdownMenuItem(text = { Text("Edit") }, onClick = { menuExpanded = false })
                    DropdownMenuItem(text = { Text("Delete") }, onClick = { menuExpanded = false })
                    DropdownMenuItem(text = { Text("Favorite") }, onClick = { menuExpanded = false })
                }
            }
        }

        // KONTEN UTAMA (SLIDER, DESKRIPSI, DLL)

        // Slider Foto Full-size
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) { pageIndex ->
            Image(
                painter = painterResource(id = album.posts[pageIndex].imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Indikator Titik Bulat
        Row(
            Modifier
                .height(30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color(0xFFFA9A97) else Color(0xff589591)
                Box(modifier = Modifier.padding(4.dp).clip(CircleShape).background(color).size(8.dp))
            }
        }

        // Deskripsi dan Tanggal
        Column(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp)) {
            val currentPost = album.posts[pagerState.currentPage]
            val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.US).format(currentPost.postDate)

            Text(
                text = currentPost.description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Posted on: $formattedDate",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPostPreview() {
    DetailPost(navController = rememberNavController())
}