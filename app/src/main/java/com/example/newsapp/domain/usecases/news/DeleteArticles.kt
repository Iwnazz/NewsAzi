package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepo

class DeleteArticles(private val newsRepo: NewsRepo) {

    suspend operator fun invoke(article: Article){
       newsRepo.deleteArticle(article)
    }
}