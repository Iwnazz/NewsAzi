package com.example.newsapp.presentation.components.onboard

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.Constance.SixDp

@Composable
fun OnBoardButton(text: String, onClick: () -> Unit) {
        Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = myGreen,
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(size = SixDp)
            ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                )
        }
}