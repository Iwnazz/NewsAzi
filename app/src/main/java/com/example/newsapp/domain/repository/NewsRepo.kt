package com.example.newsapp.domain.repository

import android.icu.text.StringSearch
import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepo {

    fun getNews(sources : List<String>):Flow<PagingData<Article>>

    fun searchNews(searchQuery: String,sources : List<String>):Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    fun selectArticle(): Flow<List<Article>>
    suspend fun selectedArticle(url: String): Article?

}