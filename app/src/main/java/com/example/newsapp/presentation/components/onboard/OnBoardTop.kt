package com.example.newsapp.presentation.components.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.R
import com.example.newsapp.presentation.ui.screens.onboarding.Page
import com.example.newsapp.ui.theme.myGreen
import com.example.newsapp.utils.BaseText
import com.example.newsapp.utils.Constance.MediumThirtyDp
import com.example.newsapp.utils.Constance.MediumTwentyFourDp

@Composable
fun OnBoardTop(
    modifier: Modifier = Modifier,
    page: Page
){
    Column(modifier = modifier) {
        Image(modifier= Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription ="page_image",
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(MediumTwentyFourDp))
        BaseText(text = page.title,
            modifier = Modifier.padding(horizontal = MediumThirtyDp),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = myGreen
            )
        BaseText(text = page.desc,
            modifier = Modifier.padding(horizontal = MediumThirtyDp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }

}
