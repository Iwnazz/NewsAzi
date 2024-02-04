package com.example.newsapp.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapp.presentation.news_navigator.NewsNavigator
import com.example.newsapp.presentation.ui.screens.home.HomeScreen
import com.example.newsapp.presentation.ui.screens.home.HomeViewModel
import com.example.newsapp.presentation.ui.screens.onboarding.OnBoardScreen
import com.example.newsapp.presentation.ui.screens.onboarding.OnBoardViewModel
import com.example.newsapp.presentation.ui.screens.search.SearchScreen
import com.example.newsapp.presentation.ui.screens.search.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectIndexed

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Route.AppStartNav.route,
            startDestination = Route.OnBoardScreen.route
        ){
            composable(
                route = Route.OnBoardScreen.route
            ){
                val viewModel : OnBoardViewModel = hiltViewModel()
                OnBoardScreen(viewModel::onEvent)
            }
        }
        navigation(
            route = Route.NewsNav.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(route = Route.NewsNavigatorScreen.route){
              NewsNavigator()
            }
        }
    }
}