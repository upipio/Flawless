package com.example.flawless.welcomepage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun FirstPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 412.dp)
            .requiredHeight(height = 917.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.flawless),
            contentDescription = "Flawless",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 45.dp,
                    y = 258.dp)
                .requiredWidth(width = 323.dp)
                .requiredHeight(height = 312.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff84bdb9),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold)
                ) {append("Flaw")}
                withStyle(style = SpanStyle(
                    color = Color(0xfffa9a97),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold)) {append("Less")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 131.dp,
                    y = 527.dp))
    }
}


@Preview(widthDp = 412, heightDp = 917)
@Composable
private fun FirstPagePreview() {
    FirstPage(Modifier)
}
