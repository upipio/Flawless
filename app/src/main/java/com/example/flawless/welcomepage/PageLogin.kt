package com.example.flawless.welcomepage

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Untitled design",
            modifier = Modifier
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 917.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_back),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 21.dp,
                    y = 25.dp)
                .requiredSize(size = 24.dp))
        Text(
            text = "Back",
            color = Color.White,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 49.dp,
                    y = 26.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 284.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 659.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = Color.White))
        Text(
            text = "Welcome Back! ",
            color = Color.Black,
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 85.dp,
                    y = 332.dp))
        Text(
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium)
                ) {append("Step Back Into Your Memories!\n")}
                withStyle(style = SpanStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)) {append("Your path is right here.")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 384.dp)
                .requiredWidth(width = 388.dp)
                .requiredHeight(height = 45.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 39.dp,
                    y = 484.dp)
                .requiredWidth(width = 323.dp)
                .requiredHeight(height = 55.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(2.dp, Color(0xff828282)),
                    shape = RoundedCornerShape(10.dp)))
        Text(
            text = "Your Email",
            color = Color(0xffb9b9b9),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 62.dp,
                    y = 501.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 39.dp,
                    y = 567.dp)
                .requiredWidth(width = 323.dp)
                .requiredHeight(height = 55.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(2.dp, Color(0xff828282)),
                    shape = RoundedCornerShape(10.dp)))
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 320.dp,
                    y = 582.dp)
                .requiredSize(size = 25.dp))
        Text(
            text = "Your Password",
            color = Color(0xffb9b9b9),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 62.dp,
                    y = 585.dp))
        val checkedState = remember { mutableStateOf(true) }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 35.dp,
                    y = 620.dp)
                .border(border = BorderStroke(2.dp, Color(0xff84bdb9))))
        Text(
            text = "Remember me",
            color = Color(0xff84bdb9),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 70.dp,
                    y = 636.dp))
        Text(
            text = "Forgot Password?",
            color = Color(0xff84bdb9),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 264.dp,
                    y = 636.dp))
        Image(
            painter = painterResource(id = R.drawable.gradasi),
            contentDescription = "gradasi",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 80.dp,
                    y = 679.dp)
                .requiredWidth(width = 253.dp)
                .requiredHeight(height = 50.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .shadow(elevation =788.dp,
                    shape = RoundedCornerShape(50.dp)))
        Text(
            text = "Log In",
            color = Color.White,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 183.dp,
                    y = 694.dp))
        Text(
            text = "Sign in with",
            color = Color(0xff84bdb9),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 173.dp,
                    y = 760.dp))
        Divider(
            color = Color(0xff84bdb9),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 98.dp,
                    y = 768.dp)
                .requiredWidth(width = 65.dp))
        Divider(
            color = Color(0xff84bdb9),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 252.dp,
                    y = 768.dp)
                .requiredWidth(width = 65.dp))
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Made by Google 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 136.dp,
                    y = 792.dp)
                .requiredSize(size = 60.dp))
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "facebook logos vector (AI, EPS, SVG, PDF, CDR) free download 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 222.dp,
                    y = 794.dp)
                .requiredSize(size = 55.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun LoginPreview() {
    LoginPage(Modifier)
}