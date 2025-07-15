package com.example.flawless.homepage

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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.flawless.AppDestinations
import com.example.flawless.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage1(
    navController: NavController,
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel = viewModel()
) {
    val postState by postViewModel.postFeedState.collectAsState()

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
                Divider(color = Color(0xff4F4F4F).copy(alpha = 0.5f), thickness = 2.dp)
            }
        },
        bottomBar = {
            Column {
                Divider(thickness = 2.dp, color = Color(0xff589591).copy(alpha = 0.6f))
                BottomAppBar(
                    containerColor = Color.White,
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            if (postState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (postState.error != null) {
                Text(
                    text = "Error: ${postState.error}",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center).padding(16.dp)
                )
            } else if (postState.posts.isEmpty()) {
                Text(
                    text = "Belum ada postingan. Buat yang pertama!",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(postState.posts) { post ->
                        PostCard(
                            post = post,
                            navController = navController,
                            postViewModel = postViewModel
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun PostCard(
    post: Post,
    navController: NavController,
    postViewModel: PostViewModel
) {
    var menuExpanded by remember { mutableStateOf(false) }
    val currentUser = Firebase.auth.currentUser
    val isFavorited = currentUser?.uid?.let { post.favoritedBy.contains(it) } ?: false

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(post.imageUrl),
                contentDescription = post.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color.LightGray)
                    .clickable { navController.navigate(AppDestinations.DETAIL_POST_PAGE) }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = post.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = post.description,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Posted by ${post.username}", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                }

                Box {
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(painter = painterResource(id = R.drawable.three_dot_vertical), contentDescription = "More options")
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        // Opsi Favorite, selalu ada untuk semua postingan
                        DropdownMenuItem(
                            text = { Text(if (isFavorited) "Unfavorite" else "Favorite") },
                            onClick = {
                                postViewModel.toggleFavorite(post.id, isFavorited)
                                menuExpanded = false
                            }
                        )

                        // Opsi Edit dan Delete hanya muncul jika post ini milik pengguna
                        if (currentUser?.uid == post.userId) {
                            DropdownMenuItem(
                                text = { Text("Edit") },
                                onClick = {
                                    // TODO: Navigasi ke halaman Edit
                                    menuExpanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Delete") },
                                onClick = {
                                    postViewModel.deletePost(post.id)
                                    menuExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePage1Preview() {
    HomePage1(navController = rememberNavController())
}