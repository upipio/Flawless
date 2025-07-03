package com.example.flawless.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = (-15).dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 78.dp)
                .background(color = Color.White))
        Image(
            painter = painterResource(id = R.drawable.flawless),
            contentDescription = "Flawless",
            modifier = Modifier
                .requiredSize(size = 60.dp))
        Image(
            painter = painterResource(id = R.drawable.mdi),
            contentDescription = "mdi-cog",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 360.dp,
                    y = 14.dp)
                .requiredSize(size = 35.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff84bdb9),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                ) {append("Photo ")}
                withStyle(style = SpanStyle(
                    color = Color(0xfffa9a97),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)) {append("Diary")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 65.dp,
                    y = 20.dp))
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 63.dp)
                .requiredWidth(width = 412.dp))
        Text(
            text = "FULLNAME",
            color = Color.White,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 120.dp,
                    y = 82.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_pp),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp,
                    y = 82.dp)
                .requiredSize(size = 70.dp))
        Text(
            text = "Posts: 1055",
            color = Color.White,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 120.dp,
                    y = 117.dp))
        Text(
            text = "New Memories, New Life. Preserving amazing moments forever!!!",
            color = Color.White,
            style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 120.dp,
                    y = 139.dp)
                .requiredWidth(width = 272.dp))
        Image(
            painter = painterResource(id = R.drawable.gradasi),
            contentDescription = "Untitled design 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 60.dp)
                .requiredWidth(width = 500.dp)
                .requiredHeight(height = 150.dp)
                .rotate(degrees = 0f))
        Image(
            painter = painterResource(id = R.drawable.mdi_heart),
            contentDescription = "mdi-heart",
            colorFilter = ColorFilter.tint(Color(0xffffa7a7)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 191.dp,
                    y = 200.dp)
                .requiredSize(size = 30.dp))
        Divider(
            color = Color(0xff589591),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 237.dp)
                .requiredWidth(width = 412.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 238.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.dp,
                    y = 238.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 276.dp,
                    y = 238.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 376.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.dp,
                    y = 376.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 276.dp,
                    y = 376.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 514.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.dp,
                    y = 514.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 276.dp,
                    y = 514.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 652.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.dp,
                    y = 652.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 276.dp,
                    y = 652.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 790.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.dp,
                    y = 790.dp)
                .requiredSize(size = 137.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "image",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 276.dp,
                    y = 790.dp)
                .requiredSize(size = 137.dp))
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
            painter = painterResource(id = R.drawable.frame_upload),
            contentDescription = "Frame",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 198.dp,
                    end = 179.dp,
                    top = 859.dp,
                    bottom = 23.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_home),
            contentDescription = "Frame",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 54.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp))
        Image(
            painter = painterResource(id = R.drawable.mdi_account_circle),
            contentDescription = "mdi-account-circle",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 342.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun ProfilePreview() {
    ProfilePage(Modifier)
}
