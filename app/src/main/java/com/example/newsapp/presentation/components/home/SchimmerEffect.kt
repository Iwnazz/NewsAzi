package com.example.newsapp.presentation.components.home

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.Constance
import com.example.newsapp.utils.Constance.DURATION
import com.example.newsapp.utils.Constance.MediumTwentyFourDp
import com.example.newsapp.utils.Constance.SixTeenDp
import com.example.newsapp.utils.Constance.ThirtyDp

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = DURATION),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    background(color = myGreen.copy(alpha = alpha))
}

@Composable
fun ArticleCardSchimmerEffect(modifier: Modifier = Modifier){
    Row(modifier = modifier){
        Box(
            modifier = Modifier
                .size(Constance.NinetySixDp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
            )

        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Constance.FourDp)
                .height(Constance.NinetySixDp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(ThirtyDp)
                    .padding(horizontal = MediumTwentyFourDp )
                    .shimmerEffect()
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(SixTeenDp)
                        .padding(horizontal =  MediumTwentyFourDp)
                        .shimmerEffect()
                )
            }
        }
    }
}