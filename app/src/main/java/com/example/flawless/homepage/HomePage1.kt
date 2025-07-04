package com.example.flawless.homepage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.AppDestinations
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage1(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // 1. Menggunakan data yang dinamis
    val albums = remember { generateFixedHomePageData() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.flawless), contentDescription = "Logo", modifier = Modifier.size(40.dp))
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
                        IconButton(onClick = { navController.navigate(AppDestinations.HOME_PAGE_OFF) }) {
                            Icon(painter = painterResource(id = R.drawable.frame_calendar), modifier = Modifier.size(24.dp), contentDescription = "List View")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
                )
                // Divider sekarang ditempatkan di sini, di dalam Column TopAppBar
                Divider(color = Color(0xff4F4F4F).copy(alpha = 0.5f), thickness = 2.dp)
            }
        },
        bottomBar = {
            // BottomAppBar dibungkus Column untuk efek shadow/pembatas
            Column {
                // Ini akan memberi efek garis bayangan di atas BottomAppBar
                Divider(thickness = 2.dp, color = Color(0xff589591).copy(alpha = 0.6f))
                BottomAppBar(
                    containerColor = Color.White,
                    // Shadow bisa ditambahkan di sini jika diinginkan
                    // modifier = Modifier.shadow(elevation = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Anda sudah di sini */ }) {
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
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            itemsIndexed(albums) { index, album ->
                // Tampilkan item HANYA jika ada postingan di bulan itu
                if (album.posts.isNotEmpty()) {
                    MonthlyAlbumItem(album = album, navController = navController)
                    // Beri pemisah jika bukan item terakhir yang punya postingan
                    if (index < albums.indexOfLast { it.posts.isNotEmpty() }) {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp))
                    }
                } else {
                    // Tampilkan placeholder untuk bulan yang kosong
                    EmptyMonthItem(month = album.month)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MonthlyAlbumItem(album: MonthlyAlbum, navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { album.posts.size })

    Column(modifier = Modifier.padding(top = 16.dp)) { // Hanya padding atas
        Text(
            text = album.month,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 24.dp), // Padding lebih besar untuk efek "peek"
            pageSpacing = 16.dp,
        ) { pageIndex ->
            val post = album.posts[pageIndex]
            PostCard(post = post, navController = navController)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier
                .height(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color(0xFFFA9A97) else Color(0xff589591)
                Box(modifier = Modifier.padding(4.dp).clip(CircleShape).background(color).size(8.dp))
            }
        }
    }
}

// Composable BARU untuk bulan yang KOSONG
@Composable
fun EmptyMonthItem(month: String) {
    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)) {
        Text(text = month, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Text("No posts yet", color = Color.Gray)
        }
    }
}


@Composable
fun PostCard(post: DiaryPost, navController: NavController) {
    var menuExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate(AppDestinations.DETAIL_POST_PAGE) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column {
            Image(
                painter = painterResource(id = post.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f) // Diubah menjadi rasio 1:1 agar lebih rapi
            )
            // 3. Perbaikan Teks dan Menu agar tidak tumpang tindih
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = post.description,
                    maxLines = 2, // Diberi 2 baris agar lebih informatif
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f, fill = true),
                    style = MaterialTheme.typography.bodySmall,
                    lineHeight = 16.sp
                )
                Box {
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(painter = painterResource(id = R.drawable.three_dot_vertical), contentDescription = "More options")
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
        }
    }
}


@Preview
@Composable
fun HomePage1Preview() {
    HomePage1(navController = rememberNavController())
}