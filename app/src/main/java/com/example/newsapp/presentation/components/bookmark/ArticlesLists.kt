package com.example.newsapp.presentation.components.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.components.home.ArticleCard
import com.example.newsapp.presentation.components.home.handlePagingResult
import com.example.newsapp.utils.Constance

@Composable
fun ArticlesLists(
    modifier: Modifier = Modifier,
    article: List<Article>,
    onClick:(Article) -> Unit
){

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Constance.MediumTwentyFourDp),
            contentPadding = PaddingValues(all = Constance.FourDp)
        ){
            items(count = article.size){
                val articles = article[it]
                ArticleCard(article = articles, onClick = { onClick(articles)})
                }
            }
}
