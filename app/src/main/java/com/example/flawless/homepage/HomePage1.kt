
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun HomePage2(modifier: Modifier = Modifier) {
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
                    fontWeight = FontWeight.Bold)) {append("Photo ")}
                withStyle(style = SpanStyle(
                    color = Color(0xfffa9a97),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)) {append("Diary")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 65.dp,
                    y = 20.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_calendar),
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
                    y = 63.dp)
                .requiredWidth(width = 412.dp))
        Text(
            text = "June 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 74.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_down),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 71.dp)
                .requiredSize(size = 30.dp)
                /*.rotate(degrees = 90f)*/)
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 7.dp,
                    y = 118.dp)
                .requiredSize(size = 290.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(3.dp, Color(0xfffa9a97)),
                    shape = RoundedCornerShape(10.dp)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 316.dp,
                    y = 118.dp)
                .requiredSize(size = 290.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(1.dp, Color(0xff263238)),
                    shape = RoundedCornerShape(10.dp)))
        Image(
            painter = painterResource(id = R.drawable.sapi),
            contentDescription = "download 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 185.dp,
                    y = 124.dp)
                .requiredWidth(width = 112.dp)
                .requiredHeight(height = 225.dp)
                .clip(shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)))
        Image(
            painter = painterResource(id = R.drawable.kurban),
            contentDescription = "Kurban idul adha 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 124.dp)
                .requiredWidth(width = 169.dp)
                .requiredHeight(height = 225.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.cewe_dan_kucing),
            contentDescription = "pap cewe sama kucing 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 322.dp,
                    y = 124.dp)
                .requiredWidth(width = 127.dp)
                .requiredHeight(height = 225.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.mdidotsvertical),
            contentDescription = "mdi-dots-vertical",
            colorFilter = ColorFilter.tint(Color(0xff4f4f4f)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 271.dp,
                    y = 365.dp)
                .requiredSize(size = 20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff4f4f4f),
                    fontSize = 12.sp)) {append("Pengalaman pertama jadi panitia kurb")}
                withStyle(style = SpanStyle(
                    color = Color(0xffb9b9b9),
                    fontSize = 12.sp)) {append(" ....")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 18.dp,
                    y = 367.dp))
        Text(
            text = "Si embul narsis sksls",
            color = Color(0xff4f4f4f),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 327.dp,
                    y = 367.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 279.dp,
                    y = 385.dp)
                .requiredWidth(width = 85.dp)
                .requiredHeight(height = 63.dp)
                .background(color = Color.White)
                .shadow(elevation = 4.dp))
        Text(
            text = "Edit ",
            color = Color(0xff4f4f4f),
            style = TextStyle(
                fontSize = 11.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 299.dp,
                    y = 390.dp)
                .requiredWidth(width = 48.dp)
                .requiredHeight(height = 12.dp))
        Divider(
            color = Color(0xff828282),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 286.dp,
                    y = 405.dp)
                .requiredWidth(width = 71.dp))
        Text(
            text = "Delete",
            color = Color(0xff4f4f4f),
            style = TextStyle(
                fontSize = 11.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 299.dp,
                    y = 410.dp)
                .requiredWidth(width = 59.dp)
                .requiredHeight(height = 12.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 213.dp,
                    y = 428.dp)
                .requiredSize(size = 11.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 199.dp,
                    y = 428.dp)
                .requiredSize(size = 11.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xfffa9a97)))
        Divider(
            color = Color(0xff828282),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 286.dp,
                    y = 428.dp)
                .requiredWidth(width = 71.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 227.dp,
                    y = 429.dp)
                .requiredSize(size = 9.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Text(
            text = "Favourite",
            color = Color(0xff4f4f4f),
            style = TextStyle(
                fontSize = 11.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 299.dp,
                    y = 429.dp)
                .requiredWidth(width = 59.dp)
                .requiredHeight(height = 12.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 239.dp,
                    y = 430.dp)
                .requiredSize(size = 7.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 249.dp,
                    y = 431.dp)
                .requiredSize(size = 5.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 257.dp,
                    y = 432.dp)
                .requiredSize(size = 3.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 262.dp,
                    y = 433.dp)
                .requiredSize(size = 1.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Text(
            text = "May 2025",
            color = Color(0xff737373),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 466.dp))
        Image(
            painter = painterResource(id = R.drawable.frame_down),
            contentDescription = "Frame",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 463.dp)
                .requiredSize(size = 30.dp)
                /*.rotate(degrees = 90f)*/)
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 7.dp,
                    y = 511.dp)
                .requiredSize(size = 290.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(1.dp, Color(0xff263238)),
                    shape = RoundedCornerShape(10.dp)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 7.dp,
                    y = 511.dp)
                .requiredSize(size = 290.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(1.dp, Color(0xff263238)),
                    shape = RoundedCornerShape(10.dp)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 316.dp,
                    y = 511.dp)
                .requiredSize(size = 290.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(border = BorderStroke(1.dp, Color(0xff263238)),
                    shape = RoundedCornerShape(10.dp)))
        Image(
            painter = painterResource(id = R.drawable.gambar_back),
            contentDescription = "f29f39bc-1002-4749-adb0-bfe7b5df7b0c 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 12.dp,
                    y = 519.dp)
                .requiredWidth(width = 251.dp)
                .requiredHeight(height = 214.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.sleeping),
            contentDescription = "Sleeping Angel 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 271.dp,
                    y = 519.dp)
                .requiredWidth(width = 26.dp)
                .requiredHeight(height = 214.dp)
                .clip(shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)))
        Image(
            painter = painterResource(id = R.drawable.ontwitter1),
            contentDescription = "on Twitter 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 320.dp,
                    y = 519.dp)
                .requiredWidth(width = 147.dp)
                .requiredHeight(height = 214.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.mdidotsvertical),
            contentDescription = "mdi-dots-vertical",
            colorFilter = ColorFilter.tint(Color(0xff4f4f4f)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 271.dp,
                    y = 754.dp)
                .requiredSize(size = 20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff4f4f4f),
                    fontSize = 12.sp)
                ) {append("Belajar gambar lagi!, hari ini selesai 1 ja")}
                withStyle(style = SpanStyle(
                    color = Color(0xffb9b9b9),
                    fontSize = 12.sp)) {append(" ....")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 18.dp,
                    y = 756.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color(0xff4f4f4f),
                    fontSize = 12.sp)) {append("Main sama si imut 1 ja")}
                withStyle(style = SpanStyle(
                    color = Color(0xffb9b9b9),
                    fontSize = 12.sp)) {append(" ....")}},
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 326.dp,
                    y = 756.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 218.dp,
                    y = 813.dp)
                .requiredSize(size = 11.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 204.dp,
                    y = 813.dp)
                .requiredSize(size = 11.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 232.dp,
                    y = 814.dp)
                .requiredSize(size = 9.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 244.dp,
                    y = 815.dp)
                .requiredSize(size = 7.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 254.dp,
                    y = 816.dp)
                .requiredSize(size = 5.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 262.dp,
                    y = 817.dp)
                .requiredSize(size = 3.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 267.dp,
                    y = 818.dp)
                .requiredSize(size = 1.dp)
                .clip(shape = CircleShape)
                .background(color = Color(0xff84bdb9)))
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
            painter = painterResource(id = R.drawable.frame_home),
            contentDescription = "Frame",
            colorFilter = ColorFilter.tint(Color(0xff589591)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 47.dp,
                    y = 859.dp)
                .requiredSize(size = 35.dp)
                .clip(shape = RoundedCornerShape(5.dp)))
        Image(
            painter = painterResource(id = R.drawable.frame_upload),
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
private fun HomePage2Preview() {
    HomePage2(Modifier)
}