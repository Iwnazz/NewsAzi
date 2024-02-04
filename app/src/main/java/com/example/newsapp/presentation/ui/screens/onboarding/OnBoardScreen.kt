package com.example.newsapp.presentation.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.newsapp.R
import com.example.newsapp.presentation.components.onboard.OnBoardButton
import com.example.newsapp.presentation.components.onboard.OnBoardIndicator
import com.example.newsapp.presentation.components.onboard.OnBoardTextButton
import com.example.newsapp.presentation.components.onboard.OnBoardTop
import com.example.newsapp.utils.Constance.FiftyTwoDp
import com.example.newsapp.utils.Constance.MediumTwentyFourDp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(
    event: (OnBoardEvent) -> Unit
) {

    Image(
        painter = painterResource(id = R.drawable.wallpaper2),
        contentDescription = "wallpaper",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.fillMaxSize()){
        val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("","")
                }
            }
        }
        HorizontalPager(state = pagerState) {
            OnBoardTop(page = pages[it])
        }
            Spacer(modifier = Modifier.weight(1f))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumTwentyFourDp)
            .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ){
                OnBoardIndicator(
                    modifier = Modifier.width(FiftyTwoDp),
                    pageSize = pages.size,
                    selectedPage = pagerState.currentPage)
        Row (verticalAlignment = Alignment.CenterVertically){
                val scope = rememberCoroutineScope()
            if (buttonState.value[0].isNotEmpty()){
                OnBoardTextButton(text = buttonState.value[0],
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    }
                )
            }
            OnBoardButton(text = buttonState.value[1], onClick = {
                scope.launch {
                    if (pagerState.currentPage == 2){
                        event(OnBoardEvent.SaveAppEntry)
                    }else{
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1
                        )
                    }
                }
            })
        }
    }
        Spacer(modifier = Modifier.weight(0.2f))
    }
}