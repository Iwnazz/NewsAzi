package com.example.newsapp.presentation.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.domain.model.Article
import com.example.newsapp.utils.Constance.FourDp
import com.example.newsapp.utils.Constance.MediumTwentyFourDp

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    article: LazyPagingItems<Article>,
    onClick:(Article) -> Unit
){
    val handlePagingResult = handlePagingResult(article = article)
    if (handlePagingResult){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumTwentyFourDp),
            contentPadding = PaddingValues(all = FourDp)
        ){
            items(count = article.itemCount){
                article[it]?.let {
                    ArticleCard(article = it, onClick = { onClick(it)})
                }
            }
        }
    }

}

@Composable
fun handlePagingResult(
    article: LazyPagingItems<Article>,
):Boolean{
    val loadState = article.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when{
        loadState.refresh is LoadState.Loading ->{
            ShimmerEffect()
            false
        }
        error != null ->{
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(MediumTwentyFourDp)) {
        repeat(10){
            ArticleCardSchimmerEffect(
                modifier = Modifier.padding(MediumTwentyFourDp)
            )
        }
    }
}