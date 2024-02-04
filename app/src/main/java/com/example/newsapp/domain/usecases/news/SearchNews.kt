package com.example.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepo
import com.example.newsapp.presentation.components.search.SearchEvent
import kotlinx.coroutines.flow.Flow

class SearchNews(private val newsRepo: NewsRepo) {
    operator fun invoke(searchQuery: String,sources: List<String>): Flow<PagingData<Article>> {
        return newsRepo.searchNews(searchQuery, sources)
    }
}