package com.example.flawless.homepage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.flawless.R


@Composable
fun CardDiary(modifier: Modifier = Modifier,
              text: String,
              date: String,
              imageModel: Any){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageModel),
            contentDescription = "Random Diary Image",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(bottom = 8.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(date, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { /*TODO: */}) {
                Text("Edit")
            }
        }
    }

}

@Preview
@Composable
fun CardDiaryPreview() {
    // Fungsi preview ini HANYA untuk melihat tampilan komponen CardDiary
    CardDiary(
        text = "Pengalaman pertama jadi panitia kurban, seru banget!",
        date = "28-06-2025",
        imageModel = R.drawable.sapi // URL gambar acak
    )
}