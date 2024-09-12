package com.khana.stayfit.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.AppFont

@Preview(showBackground = true)
@Composable
fun PageLayout(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int= R.drawable.img_goal_1,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors().copy(
            containerColor =  Color.Transparent,
            contentColor = Color.Transparent
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}
