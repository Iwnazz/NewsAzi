package com.example.newsapp.presentation.ui.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.saveread.AppEntryUseCases
import com.example.newsapp.presentation.nvgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases): ViewModel() {

        var splashCondition by mutableStateOf(true)
            private set

        var startDestination by mutableStateOf(Route.AppStartNav.route)
            private set

        init {
            appEntryUseCases.readAppEntry().onEach {
                if (it){
                    startDestination = Route.NewsNav.route
                }else{
                    startDestination = Route.AppStartNav.route
                }
                delay(300)
                splashCondition = false
            }.launchIn(viewModelScope)
        }
}