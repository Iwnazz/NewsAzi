package com.example.newsapp.domain.usecases.news

data class NewsUsesCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticles: UpsertArticles,
    val selectArticles: SelectArticles,
    val deleteArticles: DeleteArticles,
    val selectArticle2: SelectArticle2
            )
