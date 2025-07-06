package com.example.flawless.homepage


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flawless.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("Wizard news in New York!!!") }
    var description by remember { mutableStateOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nibh arcu, dapibus in blandit id, euismod et nunc.") }

    // State untuk daftar gambar yang dipilih (MutableList agar bisa diubah)
    val selectedImages = remember {
        mutableStateListOf(R.drawable.foto_cewe_1, R.drawable.foto_cewe_2)
    }

    // State untuk mengontrol dialog/popup
    var showImageDialog by remember { mutableStateOf(false) }
    var imageIndexToChange by remember { mutableStateOf<Int?>(null) }

    // Daftar semua gambar yang bisa dipilih dari drawable
    val availableImages = remember {
        listOf(
            R.drawable.foto_cewe_1, R.drawable.foto_cewe_2, R.drawable.gambar_kurban_place_holder,
            R.drawable.gambar_sapi_place_holder, R.drawable.gambar_cewe_dan_kucing_place_holder,
            R.drawable.gambar_punggung_place_holder, R.drawable.sleeping, R.drawable.ontwitter1
        )
    }

    // 1. Latar belakang putih penuh & struktur yang benar
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White, // <-- Memastikan seluruh latar belakang putih
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = { Text("Create Post", color = Color(0xfffa9a97)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.Close, contentDescription = "Cancel")
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
                )
                Divider(color = Color(0xff4F4F4F).copy(alpha = 0.5f), thickness = 2.dp)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            PhotoUploader(
                selectedImages = selectedImages,
                onAddClick = {
                    // Logika untuk menambah foto baru ke list
                    imageIndexToChange = null // Mode tambah, bukan ganti
                    showImageDialog = true
                },
                onImageClick = { index ->
                    // Logika untuk mengganti foto yang ada
                    imageIndexToChange = index
                    showImageDialog = true
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomTextField(
                label = "Title",
                value = title,
                onValueChange = { title = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                label = "About this Photo",
                value = description,
                onValueChange = { description = it },
                modifier = Modifier.height(200.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Tombol Cancel dan Save dipindahkan ke sini
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF828282)) // Warna abu-abu
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* TODO: Logika Save */ navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff589591))
                ) {
                    Text("Save")
                }
            }
        }
    }

    // 3. Logika Dialog/Popup Pemilihan Gambar
    if (showImageDialog) {
        ImagePickerDialog(
            availableImages = availableImages,
            onDismiss = { showImageDialog = false },
            onImageSelected = { newImageRes ->
                imageIndexToChange?.let { index ->
                    // Mode ganti: Ganti gambar di indeks yang dipilih
                    selectedImages[index] = newImageRes
                } ?: run {
                    // Mode tambah: Tambah gambar baru ke akhir list
                    selectedImages.add(newImageRes)
                }
                showImageDialog = false
            }
        )
    }
}

// Composable terpisah untuk Photo Uploader
@Composable
private fun PhotoUploader(
    selectedImages: List<Int>,
    onAddClick: () -> Unit,
    onImageClick: (Int) -> Unit
) {
    Column {
        Text(
            "Add Photos",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xff589591),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(selectedImages) { index, imageResId ->
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Selected image ${index + 1}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onImageClick(index) }
                )
            }
            item {
                // Tombol "Tambah"
                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Gray.copy(alpha = 0.1f))
                        .clickable(onClick = onAddClick),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.AddPhotoAlternate, contentDescription = "Add More Photos", tint = Color.Gray, modifier = Modifier.size(48.dp))
                }
            }
        }
    }
}

// Composable terpisah untuk Dialog/Popup
@Composable
private fun ImagePickerDialog(
    availableImages: List<Int>,
    onDismiss: () -> Unit,
    onImageSelected: (Int) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Choose an Image") },
        text = {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp), // Grid yang adaptif
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(availableImages) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Selectable Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onImageSelected(imageRes) }
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

@Composable
private fun CustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) { // Tambahkan sedikit padding vertikal
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xff589591),
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
private fun CreatePagePreview() {
    CreatePage(navController = rememberNavController())
}