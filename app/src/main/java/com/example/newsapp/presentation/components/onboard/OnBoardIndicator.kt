package com.example.newsapp.presentation.components.onboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.Constance.FourTeenDp
@Composable
fun OnBoardIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage : Int,
    selectedColor: Color = myGreen,
    unselectedColor: Color = Color.Gray
){
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween){
        repeat(pageSize){
            Box(modifier = Modifier.size(FourTeenDp).clip(CircleShape).
                background(color = if (it == selectedPage) selectedColor else unselectedColor)
            )

        }

    }

}