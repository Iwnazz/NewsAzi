package com.example.newsapp.presentation.ui.screens.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.example.newsapp.domain.usecases.news.NewsUsesCases
import com.example.newsapp.presentation.components.bookmark.BookMarkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(private val newsUsesCases: NewsUsesCases): ViewModel() {

    private val _state = mutableStateOf(BookMarkState())
    val state: State<BookMarkState> = _state

    init {
        getArticle()
    }

    private fun getArticle(){
      newsUsesCases.selectArticles().onEach {
            _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)
    }
}
