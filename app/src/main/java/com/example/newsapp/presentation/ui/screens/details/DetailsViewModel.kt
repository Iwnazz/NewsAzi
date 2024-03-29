package com.example.newsapp.presentation.ui.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.usecases.news.NewsUsesCases
import com.example.newsapp.presentation.components.details.DetailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUsesCases: NewsUsesCases
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUsesCases.selectArticle2(event.article.url)
                    if (article == null){
                        upsertArticle(event.article)
                    }else{
                        deleteArticle(event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect ->{
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUsesCases.deleteArticles(article = article)
        sideEffect = "Article Deleted"
    }

    private suspend fun upsertArticle(article: Article) {
        newsUsesCases.upsertArticles(article = article)
        sideEffect = "Article Saved"
    }
}