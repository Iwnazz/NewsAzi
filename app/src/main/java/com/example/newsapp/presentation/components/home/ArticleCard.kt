package com.example.newsapp.presentation.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.ui.theme.myLightGreen
import com.example.newsapp.utils.BaseText
import com.example.newsapp.utils.Constance.FourDp
import com.example.newsapp.utils.Constance.NinetySixDp
import com.example.newsapp.utils.Constance.SixDp
import com.example.newsapp.utils.Constance.TwelveDp
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    val backgroundColor = if (isDarkTheme) Color(0xFF2C2C2C) else Color.Yellow

    Box(
        modifier = modifier
            .clickable { onClick() }
            .padding(FourDp)
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .shadow(elevation = 4.dp)
    ) {
        Row {
            ArticleImage(article = article)
            ArticleContent(article = article)
        }
    }
}

@Composable
private fun ArticleImage(article: Article) {
    AsyncImage(
        modifier = Modifier
            .size(NinetySixDp)
            .clip(MaterialTheme.shapes.medium),
        model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage).build(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun ArticleContent(article: Article) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(horizontal = FourDp)
            .height(NinetySixDp)
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        ArticleInfoRow(article = article)
    }
}

@Composable
private fun ArticleInfoRow(article: Article) {
    val instant = Instant.parse(article.publishedAt)
    val dateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy")
        .withLocale(Locale.getDefault())
        .withZone(ZoneId.systemDefault())

    val publishedDate = dateFormat.format(instant)

    Row(verticalAlignment = Alignment.CenterVertically) {
        BaseText(
            text = article.source.name,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = if (isSystemInDarkTheme()) myGreen else Color.Blue // Source color based on theme
        )
        Spacer(modifier = Modifier.width(SixDp))
        Icon(
            painter = painterResource(id = R.drawable.baseline_access_time_24),
            contentDescription = "time",
            modifier = Modifier.
            size(TwelveDp),
            tint = if (isSystemInDarkTheme()) myLightGreen else Color.Red// Icon tint based on theme
        )
        Spacer(modifier = Modifier.width(SixDp))
        BaseText(
            text = publishedDate,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = if (isSystemInDarkTheme()) myGreen else Color.Gray // Published at color based on theme
        )
    }
}