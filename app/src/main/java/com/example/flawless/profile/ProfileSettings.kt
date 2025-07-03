package com.example.flawless.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flawless.R

@Composable
fun ProfileSetting(modifier: Modifier = Modifier) {
    IconButton(
        onClick = { },
        modifier = modifier
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(width = 412.dp)
                .requiredHeight(height = 917.dp)
        ) {
            Text(
                text = "Profile Setting",
                color = Color(0xfffa9a97),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 129.dp,
                        y = 20.dp))
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 17.dp,
                        y = 21.dp)
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
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 161.dp,
                        y = 86.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredSize(size = 90.dp)
                ) {
                    Image(
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
            Text(
                text = "+ Edit Photo Profile",
                color = Color(0xff84bdb9),
                style = TextStyle(
                    fontSize = 16.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 134.dp,
                        y = 184.dp))
            Text(
                text = "Fullname",
                color = Color(0xff589591),
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 35.dp,
                        y = 245.dp)
                    .requiredWidth(width = 69.dp)
                    .requiredHeight(height = 15.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f),
                    focusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 23.dp,
                        y = 269.dp)
                    .requiredWidth(width = 367.dp)
                    .requiredHeight(height = 40.dp)
                    .clip(shape = RoundedCornerShape(10.dp)))
            Text(
                text = "Fullname",
                color = Color(0xff4f5e66),
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 40.dp,
                        y = 280.dp)
                    .requiredWidth(width = 75.dp)
                    .requiredHeight(height = 18.dp))
            Text(
                text = "Email",
                color = Color(0xff589591),
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 35.dp,
                        y = 342.dp)
                    .requiredWidth(width = 69.dp)
                    .requiredHeight(height = 15.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f),
                    focusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 23.dp,
                        y = 366.dp)
                    .requiredWidth(width = 367.dp)
                    .requiredHeight(height = 44.dp)
                    .clip(shape = RoundedCornerShape(10.dp)))
            Text(
                text = "email@gmail.com",
                color = Color(0xff4f5e66),
                textDecoration = TextDecoration.Underline,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 42.dp,
                        y = 379.dp)
                    .requiredWidth(width = 158.dp)
                    .requiredHeight(height = 18.dp))
            Text(
                text = "Bio",
                color = Color(0xff589591),
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 35.dp,
                        y = 440.dp)
                    .requiredWidth(width = 69.dp)
                    .requiredHeight(height = 15.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f),
                    focusedContainerColor = Color(0xffffa7a7).copy(alpha = 0.5f)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 23.dp,
                        y = 463.dp)
                    .requiredWidth(width = 367.dp)
                    .requiredHeight(height = 109.dp)
                    .clip(shape = RoundedCornerShape(10.dp)))
            Text(
                text = "New Memories, New Life. Preserving amazing moments forever!!!",
                color = Color(0xff4f5e66),
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 42.dp,
                        y = 475.dp)
                    .requiredWidth(width = 317.dp)
                    .requiredHeight(height = 43.dp))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 310.dp,
                        y = 611.dp)
                    .requiredWidth(width = 86.dp)
                    .requiredHeight(height = 26.dp)
                    .clip(shape = RoundedCornerShape(7.dp))
                    .background(color = Color(0xff589591)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 205.dp,
                        y = 611.dp)
                    .requiredWidth(width = 86.dp)
                    .requiredHeight(height = 26.dp)
                    .clip(shape = RoundedCornerShape(7.dp))
                    .background(color = Color(0xff828282)))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 338.dp,
                        y = 614.dp)
                    .requiredWidth(width = 38.dp)
                    .requiredHeight(height = 19.dp)){ }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 223.dp,
                        y = 614.dp)
                    .requiredWidth(width = 54.dp)
                    .requiredHeight(height = 19.dp)){ }
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = (-52).dp,
                        y = 837.dp
                    )
                    .shadow(elevation = 4.dp),
                content = TODO()
            )
            Image(
                painter = painterResource(id = R.drawable.mdi),
                contentDescription = "mdi-cog",
                colorFilter = ColorFilter.tint(Color(0xff589591)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 189.dp,
                        y = 859.dp)
                    .requiredSize(size = 35.dp))
        }
    }
}

@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun ProfileSettingPreview() {
    ProfileSetting(Modifier)
}