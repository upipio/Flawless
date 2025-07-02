package com.example.flawless.homepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun Create(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 16.dp,
                    y = 16.dp)
                .requiredSize(size = 35.dp))
        Text(
            text = "Create Post",
            color = Color(0xfffa9a97),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                        .offset(x = 145.dp,
                    y = 20.dp))
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 65.dp)
                .requiredWidth(width = 412.dp))
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = "image 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 15.dp,
                    y = 93.dp)
                .requiredWidth(width = 174.dp)
                .requiredHeight(height = 258.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .border(border = BorderStroke(1.dp, Color(0xff84bdb9)),
                    shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.image2),
            contentDescription = "image 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 195.dp,
                    y = 93.dp)
                .requiredSize(size = 258.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .border(border = BorderStroke(1.dp, Color(0xff84bdb9)),
                    shape = RoundedCornerShape(5.dp)))
        Text(
            text = "Title",
            color = Color(0xff589591),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 33.dp,
                    y = 426.dp)
                .requiredWidth(width = 69.dp)
                .requiredHeight(height = 15.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 21.dp,
                    y = 450.dp)
                .requiredWidth(width = 367.dp)
                .requiredHeight(height = 40.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(0xffffa7a7).copy(alpha = 0.5f))
                .border(border = BorderStroke(1.dp, Color(0xfffa9a97)),
                    shape = RoundedCornerShape(10.dp)))
        Text(
            text = "Wizard news in New York!!!",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 38.dp,
                    y = 461.dp)
                .requiredWidth(width = 318.dp)
                .requiredHeight(height = 18.dp))
        Text(
            text = "About this Photo",
            color = Color(0xff589591),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 33.dp,
                    y = 514.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 21.dp,
                    y = 536.dp)
                .requiredWidth(width = 367.dp)
                .requiredHeight(height = 125.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(0xffffa7a7).copy(alpha = 0.5f))
                .border(border = BorderStroke(1.dp, Color(0xfffa9a97)),
                    shape = RoundedCornerShape(10.dp)))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nibh arcu, dapibus in blandit id, euismod et nunc. Aenean orci tellus, ultrices porta pretium nec, consectetur in neque. Vestibulum laoreet ex quis lacus elementum lobortis. ",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 31.dp,
                    y = 548.dp)
                .requiredWidth(width = 351.dp)
                .requiredHeight(height = 144.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 308.dp,
                    y = 700.dp)
                .requiredWidth(width = 86.dp)
                .requiredHeight(height = 26.dp)
                .clip(shape = RoundedCornerShape(7.dp))
                .background(color = Color(0xff589591)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 203.dp,
                    y = 700.dp)
                .requiredWidth(width = 86.dp)
                .requiredHeight(height = 26.dp)
                .clip(shape = RoundedCornerShape(7.dp))
                .background(color = Color(0xff828282)))
        Text(
            text = "Save",
            color = Color.White,
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 336.dp,
                    y = 703.dp)
                .requiredWidth(width = 38.dp)
                .requiredHeight(height = 19.dp))
        Text(
            text = "Cancel",
            color = Color.White,
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 221.dp,
                    y = 703.dp)
                .requiredWidth(width = 54.dp)
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
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun CreatePreview() {
    Create(Modifier)
}