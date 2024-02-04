package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepo

class SelectArticle2 (private val newsRepo: NewsRepo){

    suspend operator fun invoke(url : String): Article?{
        return newsRepo.selectedArticle(url)
    }

}