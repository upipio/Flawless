package com.example.flawless.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun Security(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = (-52).dp,
                    y = 837.dp
                )
                .requiredWidth(width = 535.dp)
                .requiredHeight(height = 80.dp)
                .background(color = Color.White)
                .shadow(elevation = 4.dp)
        )
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 0.dp,
                    y = 65.dp
                )
                .requiredWidth(width = 412.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frame_back),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 17.dp,
                    y = 21.dp
                )
                .requiredSize(size = 24.dp)
        )
        Text(
            text = "Security",
            color = Color(0xfffa9a97),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 163.dp,
                    y = 19.dp
                )
        )

        // Renamed for the first switch (e.g., two-factor auth)
        val twoFactorAuthState = remember { mutableStateOf(true) }
        Switch(
            checked = twoFactorAuthState.value,
            onCheckedChange = { twoFactorAuthState.value = it },
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 326.dp, // Consider if this offset is correct or the one below
                    y = 174.dp  // Or 178.dp for the text below
                )
        )
        Text(
            text = "Two-factor authentication",
            color = Color(0xff263238),
            style = TextStyle(
                fontSize = 15.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 25.dp,
                    y = 178.dp
                )
                .requiredWidth(width = 276.dp)
                .requiredHeight(height = 19.dp)
        )

        // Renamed for the second switch (e.g., Google sign-in)
        val googleSignInState = remember { mutableStateOf(true) }
        Switch(
            checked = googleSignInState.value,
            onCheckedChange = { googleSignInState.value = it },
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 322.dp, // Consider if this offset is correct or the one below
                    y = 359.dp  // Or 363.dp for the text below
                )
        )
        Text(
            text = "Sign In with Google",
            color = Color(0xff263238),
            style = TextStyle(
                fontSize = 15.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 21.dp,
                    y = 363.dp
                )
                .requiredWidth(width = 276.dp)
                .requiredHeight(height = 19.dp)
        )
        Text(
            text = "Include additional security like enabling two-factor authentication and checking your connected devices list to keep your account, Pins, and boards safe.",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 21.dp,
                    y = 84.dp
                )
                .requiredWidth(width = 367.dp)
                .requiredHeight(height = 72.dp)
        )
        Text(
            text = "This action makes your account extra secure. In addition to your password, you will also need to enter a secret code that we send to your phone every time you log in.",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 21.dp,
                    y = 229.dp
                )
                .requiredWidth(width = 320.dp)
                .requiredHeight(height = 72.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.mdi),
            contentDescription = "mdi-cog",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 189.dp,
                    y = 859.dp
                )
                .requiredSize(size = 35.dp)
        )
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun SecurityPreview() {
    Security(Modifier)
}