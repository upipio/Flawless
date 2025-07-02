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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun HomePageOff(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.flawless),
            contentDescription = "ChatGPT Image Jun 6, 2025, 09_22_39 PM",
            modifier = Modifier
                .requiredSize(size = 60.dp))
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
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 354.dp,
                    y = 20.dp)
                .requiredSize(size = 30.dp))
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 64.dp)
                .requiredWidth(width = 412.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 71.dp)
                .requiredSize(size = 30.dp)
                .rotate(degrees = -90f))
        Text(
            text = "June 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 74.dp))
        Divider(
            color = Color(0xff4f4f4f).copy(alpha = 0.15f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 119.dp)
                .requiredWidth(width = 412.dp)
                .shadow(elevation = 2.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 133.dp)
                .requiredSize(size = 30.dp)
                .rotate(degrees = -90f))
        Text(
            text = "May 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 136.dp))
        Divider(
            color = Color(0xff4f4f4f).copy(alpha = 0.15f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 177.dp)
                .requiredWidth(width = 412.dp)
                .shadow(elevation = 2.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 191.dp)
                .requiredSize(size = 30.dp)
                .rotate(degrees = -90f))
        Text(
            text = "April 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 194.dp))
        Divider(
            color = Color(0xff4f4f4f).copy(alpha = 0.15f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 236.dp)
                .requiredWidth(width = 412.dp)
                .shadow(elevation = 2.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 250.dp)
                .requiredSize(size = 30.dp)
                .rotate(degrees = -90f))
        Text(
            text = "Maret 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 253.dp))
        Divider(
            color = Color(0xff4f4f4f).copy(alpha = 0.15f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 293.dp)
                .requiredWidth(width = 412.dp)
                .shadow(elevation = 2.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 307.dp)
                .requiredSize(size = 30.dp)
                .rotate(degrees = -90f))
        Text(
            text = "Februari 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 310.dp))
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
            painter = painterResource(id = R.drawable.mdiaccountcircleoutline),
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
private fun HomePageOffPreview() {
    HomePageOff(Modifier)
}