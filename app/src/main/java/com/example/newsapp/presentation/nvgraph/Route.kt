package com.example.newsapp.presentation.nvgraph

sealed class Route(val route:String){

    object OnBoardScreen : Route(route = "OnBoardScreen")
    object HomeScreen : Route(route = "HomeScreen")
    object SearchScreen : Route(route = "SearchScreen")
    object BookMarkScreen : Route(route = "BookmarkScreen")
    object DetailsScreen : Route(route = "DetailsScreen")
    object AppStartNav : Route(route = "AppStartNav")
    object NewsNav : Route(route = "NewsNav")
    object NewsNavigatorScreen : Route(route = "NewsNavigatorScreen")

}
