package com.example.newsapp.presentation.ui.screens.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R
import com.example.newsapp.utils.Constance.desc
import com.example.newsapp.utils.Constance.desc1
import com.example.newsapp.utils.Constance.desc2
import com.example.newsapp.utils.Constance.title
import com.example.newsapp.utils.Constance.title1
import com.example.newsapp.utils.Constance.title2

data class Page(
    val title : String,
    val desc : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(title = title, desc = desc, image = R.drawable.bbc),
    Page(title = title1, desc = desc1, image = R.drawable.abc),
    Page(title = title2, desc = desc2, image = R.drawable.jazeera)
)