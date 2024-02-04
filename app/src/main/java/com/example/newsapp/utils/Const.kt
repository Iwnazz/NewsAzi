package com.example.newsapp.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Constance {
    val MediumTwentyFourDp = 24.dp
    val MediumThirtyDp = 30.dp
    val SixDp = 6.dp
    val FourTeenDp = 14.dp
    val TwelveSp = 12.sp
    val FiftyTwoDp = 52.dp
    val NinetySixDp = 96.dp
    val FourDp = 4.dp
    val TwelveDp = 12.dp
    val ThirtyDp = 30.dp
    val SixTeenDp = 16.dp
    val TwentyDp = 20.dp
    val HundredFiftyDp = 150.dp
    val ArticleImageHeight = 248.dp
    const val DURATION = 1000
    const val USER_SETTINGS = "userSettings"
    const val NEWS_DATA_BASE_NAME = "news_db"
    const val APP_ENTRY = "appEntry"
    const val API_KEY = "df23dd9d47fd41ffb8b9e4208a10f390"
    const val BASE_URL = "https://newsapi.org/v2/"
    const val title = "Freshest news from BBC"
    const val title1 = "Freshest news from ABC"
    const val title2 = "News from Al Jazeera!"
    const val desc = "Looking for the latest news from the BBC? You're lucky because they're here!"
    const val desc1 = "You can also find the latest news from ABC. How lucky are you!!!"
    const val desc2 = "And even news from Al Jazeera to keep you up to date with the latest news from the Middle East. Happy reading the news!"
}

@Composable
fun BaseText(
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier,
) {
        Text(
            text = text,
            style = style,
            color = color,
            modifier = modifier,

        )
}


