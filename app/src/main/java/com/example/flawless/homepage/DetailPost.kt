package com.example.flawless.homepage

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.flawless.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPost(
    postId: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailPostViewModel = viewModel(),
    // PostViewModel untuk aksi Favorite/Delete
    postViewModel: PostViewModel = viewModel()
) {
    val state by detailViewModel.postDetailState.collectAsState()
    var menuExpanded by remember { mutableStateOf(false) }
    val currentUser = Firebase.auth.currentUser

    LaunchedEffect(key1 = postId) {
        detailViewModel.fetchPostById(postId)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 16.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text("Back", style = MaterialTheme.typography.titleMedium, color = Color(0xFFFA9A97))
        }
        Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 2.dp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (state.error != null) {
                Text(
                    text = "Error: ${state.error}",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center).padding(16.dp)
                )
            } else if (state.post != null) {
                val post = state.post!!
                val isFavorited = currentUser?.uid?.let { post.favoritedBy.contains(it) } ?: false

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = post.title,
                            style = MaterialTheme.typography.titleLarge,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )

                        // Menu Titik Tiga
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
                                        // Refresh halaman detail untuk melihat perubahan
                                        detailViewModel.fetchPostById(postId)
                                        menuExpanded = false
                                    }
                                )
                                if (currentUser?.uid == post.userId) {
                                    DropdownMenuItem(
                                        text = { Text("Delete") },
                                        onClick = {
                                            postViewModel.deletePost(post.id)
                                            // Setelah hapus, kembali ke halaman sebelumnya
                                            navController.popBackStack()
                                            menuExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Image(
                        painter = rememberAsyncImagePainter(post.imageUrl),
                        contentDescription = post.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .background(Color.LightGray)
                    )

                    Column(Modifier.padding(16.dp)) {
                        val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.US).format(Date(post.timestamp))
                        Text(
                            text = post.description,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Posted by ${post.username} on: $formattedDate",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPostPreview() {
    DetailPost(postId = "dummyId", navController = rememberNavController())
}