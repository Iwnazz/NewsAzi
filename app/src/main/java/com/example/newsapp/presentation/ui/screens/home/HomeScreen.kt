package com.example.newsapp.presentation.ui.screens.home

import android.telecom.Call.Details
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.components.home.ArticlesList
import com.example.newsapp.presentation.components.home.SearchBar
import com.example.newsapp.presentation.nvgraph.Route
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.Constance.HundredFiftyDp
import com.example.newsapp.utils.Constance.MediumTwentyFourDp
import com.example.newsapp.utils.Constance.ThirtyDp
import com.example.newsapp.utils.Constance.TwelveSp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    article: LazyPagingItems<Article>,
    navigateToSearchScreen: () -> Unit,
    navigateToDetails: (Article) -> Unit
){
    Image(
        painter = painterResource(id = R.drawable.wallpaper),
        contentDescription = "wallpaper",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    val titles by remember {
        derivedStateOf {
            if (article.itemCount > 10){
                article.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83C\uDF10 "){it.title}
            }else{
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumTwentyFourDp)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "logo",
            modifier = Modifier
                .width(HundredFiftyDp)
                .height(ThirtyDp)
                .padding(horizontal = MediumTwentyFourDp)
        )
        
        Spacer(modifier = Modifier.height(MediumTwentyFourDp))

        SearchBar(
            modifier = Modifier.padding(horizontal = MediumTwentyFourDp),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {navigateToSearchScreen()},
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(MediumTwentyFourDp))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumTwentyFourDp)
                .basicMarquee(),
            fontSize = TwelveSp,
            color = myGreen)

        Spacer(modifier = Modifier.height(MediumTwentyFourDp))
        
        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumTwentyFourDp),
            article = article,
            onClick = {
                navigateToDetails(it)
            })
    }

}