package com.example.newsapp.presentation.ui.screens.search


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.components.home.ArticlesList
import com.example.newsapp.presentation.components.home.SearchBar
import com.example.newsapp.presentation.components.search.SearchEvent
import com.example.newsapp.presentation.components.search.SearchState
import com.example.newsapp.presentation.nvgraph.Route
import com.example.newsapp.utils.Constance.MediumTwentyFourDp

@Composable
fun SearchScreen(
    searchState: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails:(Article) -> Unit
    ) {
    Column(modifier = Modifier
        .padding(
            top = MediumTwentyFourDp,
            start = MediumTwentyFourDp,
            end = MediumTwentyFourDp
        )
        .statusBarsPadding()) {
        SearchBar(
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {event(SearchEvent.SearchNews)})
        Spacer(modifier = Modifier.height(MediumTwentyFourDp))
        searchState.articles?.let {
            val article = it.collectAsLazyPagingItems()
            ArticlesList(article = article, onClick ={navigateToDetails(it)})
        }
    }
}