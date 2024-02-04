package com.example.newsapp.presentation.ui.screens.bookmark

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.components.bookmark.ArticlesLists
import com.example.newsapp.presentation.components.bookmark.BookMarkState
import com.example.newsapp.presentation.nvgraph.Route
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.Constance.MediumTwentyFourDp

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigateToDetails: (Article) -> Unit
) {

    Image(
        painter = painterResource(id = R.drawable.wallpaper),
        contentDescription = "wallpaper",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(start =  MediumTwentyFourDp, top =MediumTwentyFourDp , end =MediumTwentyFourDp )
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = myGreen
        )
        Spacer(modifier = Modifier.height(MediumTwentyFourDp ))

        ArticlesLists(article = state.articles, onClick = { navigateToDetails(it)})
    }
}