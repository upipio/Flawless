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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.flawless.AppDestinations
import com.example.flawless.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage1(
    navController: NavController,
    targetMonth: String? = null, // Terima argumen bulan
    modifier: Modifier = Modifier,
    postViewModel: PostViewModel = viewModel()
) {
    val postState by postViewModel.postFeedState.collectAsState()
    val listState = rememberLazyListState() // State untuk mengontrol LazyColumn
    val scope = rememberCoroutineScope()

    LaunchedEffect(postState.groupedPosts) {
        if (!targetMonth.isNullOrEmpty() && postState.groupedPosts.isNotEmpty()) {
            val monthList = postState.groupedPosts.keys.toList()
            val targetIndex = monthList.indexOf(targetMonth)
            if (targetIndex != -1) {
                // Animasi scroll ke item bulan yang dituju
                scope.launch {
                    listState.animateScrollToItem(index = targetIndex)
                }
            }
        }
    }

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
                        IconButton(onClick = {}) {
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
            } else if (postState.groupedPosts.isEmpty()) {
                Text(
                    text = "Belum ada postingan. Buat yang pertama!",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    state = listState, // state ke LazyColumn
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(postState.groupedPosts.entries.toList()) { (month, posts) ->
                        MonthlyAlbumItem(
                            month = month,
                            posts = posts,
                            navController = navController,
                            postViewModel = postViewModel
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MonthlyAlbumItem(
    month: String,
    posts: List<Post>,
    navController: NavController,
    postViewModel: PostViewModel // ViewModel
) {
    val pagerState = rememberPagerState(pageCount = { posts.size })

    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = month,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 24.dp),
            pageSpacing = 16.dp,
        ) { pageIndex ->
            PostCard(
                post = posts[pageIndex],
                navController = navController,
                postViewModel = postViewModel // Kirim instance ViewModel yang sama
            )
        }
        Row(
            Modifier
                .height(20.dp)
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color(0xFFFA9A97) else Color(0xff589591)
                Box(modifier = Modifier.padding(4.dp).clip(CircleShape).background(color).size(8.dp))
            }
        }
    }
}

@Composable
fun PostCard(
    post: Post,
    navController: NavController,
    postViewModel: PostViewModel // Terima ViewModel
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
                    .clickable {
                        navController.navigate(AppDestinations.createDetailPostRoute(post.id))
                    }
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
                        DropdownMenuItem(
                            text = { Text(if (isFavorited) "Unfavorite" else "Favorite") },
                            onClick = {
                                postViewModel.toggleFavorite(post.id, isFavorited)
                                menuExpanded = false
                            }
                        )
                        if (currentUser?.uid == post.userId) {
                            DropdownMenuItem(
                                text = { Text("Edit") },
                                onClick = {
                                    navController.navigate(AppDestinations.createEditPostRoute(post.id))
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