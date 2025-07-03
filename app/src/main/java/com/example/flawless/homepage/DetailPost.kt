package com.example.flawless.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun DetailPost1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Text(
            text = "Back",
            color = Color(0xfffa9a97),
            style = TextStyle(
                fontSize = 22.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 52.dp,
                    y = 20.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 17.dp,
                    y = 21.dp)
                .requiredSize(size = 24.dp))
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 65.dp)
                .requiredWidth(width = 412.dp))
        Image(
            painter = painterResource(id = R.drawable.mdidotsvertical),
            contentDescription = "mdi-dots-vertical",
            colorFilter = ColorFilter.tint(Color(0xff4f4f4f)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 380.dp,
                    y = 76.dp)
                .requiredSize(size = 20.dp))
        Text(
            text = "Pertama kali jadi panitia Kurban",
            color = Color(0xff263238),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 17.dp,
                    y = 76.dp))
        Image(
            painter = painterResource(id = R.drawable.kurban),
            contentDescription = "Kurban idul adha 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 106.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 550.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 206.dp,
                    y = 664.dp)
                .requiredSize(size = 5.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xffffa7a7)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 215.dp,
                    y = 664.dp)
                .requiredSize(size = 5.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 224.dp,
                    y = 664.dp)
                .requiredSize(size = 5.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Text(
            text = "Pengalaman pertama jadi panitia kurban di hari raya Idul Adha di tahun 2025. Alhamdulillah di kasih kesempatan buat jadi panitia kurban, senang rasanya bisa membantu di hari besar seperti ini ditambah dapet daging tambahan karna jadi panitia wkwkwk.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            color = Color(0xff4f4f4f),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 691.dp)
                .requiredWidth(width = 385.dp)
                .requiredHeight(height = 105.dp))
        Text(
            text = "6 June 2025",
            color = Color(0xff828282),
            style = TextStyle(
                fontSize = 11.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 807.dp)
                .requiredWidth(width = 144.dp)
                .requiredHeight(height = 19.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-52).dp,
                    y = 837.dp)
                .requiredWidth(width = 535.dp)
                .requiredHeight(height = 80.dp)
                .background(color = Color.White)
                .shadow(elevation = 4.dp))
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "mdi-account-circle-outline",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 342.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 47.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 198.dp,
                    end = 179.dp,
                    top = 859.dp,
                    bottom = 23.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun DetailPost1Preview() {
    DetailPost1(Modifier)
}