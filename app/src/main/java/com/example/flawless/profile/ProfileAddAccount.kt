package com.example.flawless.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun AddAccount(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Text(
            text = "Add Account",
            color = Color(0xfffa9a97),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 163.dp,
                    y = 19.dp))
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 17.dp,
                    y = 21.dp)
                .requiredSize(size = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.frame_back),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
                Image(
                    painter = painterResource(id = R.drawable.frame_back),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
            }
        }
        Divider(
            color = Color(0xff4f4f4f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = 65.dp)
                .requiredWidth(width = 412.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 24.dp,
                    y = 95.dp)
                .requiredSize(size = 70.dp)
                .clip(shape = CircleShape)){ }
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 32.dp,
                    y = 105.dp)
                .requiredSize(size = 50.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mdi_account_plus_outline),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
            }
        }
        Text(
            text = "Existing Account",
            color = Color(0xff263238),
            style = TextStyle(
                fontSize = 20.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 115.dp,
                    y = 111.dp)
                .requiredWidth(width = 204.dp)
                .requiredHeight(height = 19.dp))
        Text(
            text = "Add an account you already have",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 115.dp,
                    y = 137.dp)
                .requiredWidth(width = 246.dp)
                .requiredHeight(height = 18.dp))
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 17.dp,
                    y = 215.dp)
                .requiredSize(size = 80.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.frame_eye),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
                Image(
                    painter = painterResource(id = R.drawable.frame_back),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
            }
        }
        Text(
            text = "New Account",
            color = Color(0xff263238),
            style = TextStyle(
                fontSize = 20.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 115.dp,
                    y = 230.dp)
                .requiredWidth(width = 204.dp)
                .requiredHeight(height = 19.dp))
        Text(
            text = "Add an account you already have",
            color = Color(0xff4f5e66),
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 115.dp,
                    y = 256.dp)
                .requiredWidth(width = 246.dp)
                .requiredHeight(height = 18.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-52).dp,
                    y = 837.dp)
                .requiredWidth(width = 535.dp)
                .requiredHeight(height = 80.dp)
                .background(color = Color.White)
                .shadow(elevation = 4.dp))
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 189.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 35.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mdi,
                    contentDescription = "Vector",
                    modifier = Modifier
                        .fillMaxSize())
            }
        }
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun AddAccountPreview() {
    AddAccount(Modifier)
}