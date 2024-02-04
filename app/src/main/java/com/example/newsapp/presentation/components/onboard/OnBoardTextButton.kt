package com.example.newsapp.presentation.components.onboard

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.utils.BaseText

@Composable
fun OnBoardTextButton(text: String, onClick: () -> Unit){
    TextButton(onClick = onClick) {
        BaseText(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = Color.White
            )
    }

}