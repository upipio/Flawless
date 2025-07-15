package com.example.flawless.profile

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.AppDestinations
import com.example.flawless.R
import com.example.flawless.homepage.generateFixedHomePageData
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(
    navController: NavController,
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = viewModel() // Tambahkan ViewModel
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Ambil state dari ViewModel
    val state by profileViewModel.profileState.collectAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            SettingsDrawerContent(navController = navController, drawerState = drawerState)
        },
        gesturesEnabled = true,
        scrimColor = Color.Black.copy(alpha = 0.3f)
    ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                // ... (Kode TopAppBar tidak berubah)
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
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(Icons.Default.Settings, contentDescription = "Settings")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
                    )
                    Divider(color = Color.Gray.copy(alpha = 0.3f))
                }
            },
            bottomBar = {
                // ... (Kode BottomAppBar tidak berubah)
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
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (state.isLoading) {
                    // Tampilkan loading indicator jika sedang memuat
                    CircularProgressIndicator(modifier = Modifier.padding(top = 64.dp))
                } else if (state.error != null) {
                    // Tampilkan pesan error jika terjadi kesalahan
                    Text(
                        text = "Error: ${state.error}",
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    // Tampilkan konten jika berhasil
                    ProfileHeader(userProfile = state.userProfile)

                    Icon(
                        painter = painterResource(id = R.drawable.mdi_heart),
                        contentDescription = "Favorite section",
                        tint = Color(0xffffa7a7),
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .size(30.dp)
                    )

                    // Data grid foto masih menggunakan data statis untuk saat ini
                    val favoritePosts = remember {
                        generateFixedHomePageData().flatMap { it.posts }.shuffled()
                    }
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier
                            .heightIn(max = 1000.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        contentPadding = PaddingValues(2.dp)
                    ) {
                        items(favoritePosts) { post ->
                            Image(
                                painter = painterResource(id = post.imageUrl),
                                contentDescription = "Favorite post",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.aspectRatio(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

// Ubah ProfileHeader untuk menerima data UserProfile
@Composable
fun ProfileHeader(userProfile: UserProfile?) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color(0xff84bdb9), Color(0xfffa9a97))
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(gradient)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.mdi_account_circle),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    // Tampilkan nama dari UserProfile, atau "Loading..."
                    text = userProfile?.fullname?.uppercase() ?: "LOADING...",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    // Tampilkan email dari UserProfile
                    text = userProfile?.email ?: "",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    // Tampilkan bio dari UserProfile
                    text = userProfile?.bio ?: "",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )
            }
        }
    }
}

// ... (Kode SettingsDrawerContent dan Preview tidak berubah)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDrawerContent(
    navController: NavController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    ModalDrawerSheet(
        modifier = Modifier.width(250.dp),
        drawerContainerColor = Color.White,
        drawerContentColor = Color.Black
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xfffa9a97))
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Settings", color = Color.White, style = MaterialTheme.typography.titleLarge)
            }
            Column {
                SettingMenuItem(text = "Profile Setting") {
                    scope.launch { drawerState.close() }
                    navController.navigate(AppDestinations.PROFILE_SETTINGS_PAGE)
                }
                SettingMenuItem(text = "Security") {
                    scope.launch { drawerState.close() }
                    navController.navigate(AppDestinations.SECURITY_PAGE)
                }
                SettingMenuItem(text = "Add Account") {
                    scope.launch { drawerState.close() }
                    navController.navigate(AppDestinations.ADD_ACCOUNT_PAGE)
                }
                SettingMenuItem(text = "Account") {
                    scope.launch { drawerState.close() }
                    navController.navigate(AppDestinations.WELCOME_PAGE)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            SettingMenuItem(text = "Logout") {
                scope.launch { drawerState.close() }
                navController.navigate(AppDestinations.WELCOME_PAGE) {
                    popUpTo(0) { inclusive = true }
                }
            }
        }
    }
}
@Composable
fun SettingMenuItem(text: String, onClick: () -> Unit) {
    Column {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        Divider(color = Color.Gray.copy(alpha = 0.2f))
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage(navController = rememberNavController())
}