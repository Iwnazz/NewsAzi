package com.example.newsapp.presentation.components.bookmark

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.usecases.news.SelectArticles

data class BookMarkState(
    val articles: List<Article> = emptyList()
)
