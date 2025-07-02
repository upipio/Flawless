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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flawless.R

@Composable
fun SignUpPage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        // --- GAMBAR LATAR BELAKANG DIPINDAHKAN KE SINI ---
        // Menjadi elemen pertama agar berada di paling belakang
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Untitled design",
            modifier = Modifier
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 917.dp)
                .rotate(degrees = -180f)
        )

        // --- Semua elemen UI lainnya tetap di sini ---
        Image(
            painter = painterResource(id = R.drawable.frame_eye),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 10.dp,
                    y = 22.dp)
                .requiredSize(size = 24.dp))
        Text(
            text = "Back",
            color = Color.White,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 38.dp,
                    y = 23.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 217.dp)
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 739.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = Color.White))
        Text(
            text = "Create Your Account!",
            color = Color.Black,
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 43.dp,
                    y = 269.dp))
        Text(
            text = "Ready to begin your visual storytelling journey? Create an account to unlock your diary.",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 8.dp,
                    y = 319.dp)
                .requiredWidth(width = 388.dp)
                .requiredHeight(height = 45.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 43.dp,
                    y = 394.dp)
                .requiredWidth(width = 323.dp)
                .requiredHeight(height = 55.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(2.dp, Color(0xff828282)),
                    shape = RoundedCornerShape(10.dp)))
        Text(
            text = "Fullname",
            color = Color(0xffb9b9b9),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 66.dp,
                    y = 411.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 43.dp,
                    y = 477.dp)
                .requiredWidth(width = 323.dp)
                .requiredHeight(height = 55.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(2.dp, Color(0xff828282)),
                    shape = RoundedCornerShape(10.dp)))
        Text(
            text = " Email",
            color = Color(0xffb9b9b9),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 66.dp,
                    y = 494.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 43.dp,
                    y = 559.dp)
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
                .offset(x = 324.dp,
                    y = 574.dp)
                .requiredSize(size = 25.dp))
        Text(
            text = "Password",
            color = Color(0xffb9b9b9),
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 66.dp,
                    y = 577.dp))
        Image(
            painter = painterResource(id = R.drawable.gradasi),
            contentDescription = "gradasi",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 78.dp,
                    y = 656.dp)
                .requiredWidth(width = 253.dp)
                .requiredHeight(height = 50.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .shadow(elevation = 4.dp,
                    shape = RoundedCornerShape(50.dp)))
        Text(
            text = "Get Started",
            color = Color.White,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 161.dp,
                    y = 671.dp))
        Text(
            text = "Sign up with",
            color = Color(0xffffa7a7),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 171.dp,
                    y = 755.dp))
        Divider(
            color = Color(0xfffa9a97),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 96.dp,
                    y = 763.dp)
                .requiredWidth(width = 65.dp))
        Divider(
            color = Color(0xfffa9a97),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 250.dp,
                    y = 763.dp)
                .requiredWidth(width = 65.dp))
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Made by Google 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 135.dp,
                    y = 792.dp)
                .requiredSize(size = 60.dp))
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "facebook logos vector (AI, EPS, SVG, PDF, CDR) free download 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 221.dp,
                    y = 794.dp)
                .requiredWidth(width = 55.dp)
                .requiredHeight(height = 55.dp))
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun SignUpPreview() {
    SignUpPage(
        navController = TODO(),
        modifier = TODO()
    )
}