package com.khana.stayfit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.ComposePagerTheme
import com.khana.stayfit.components.AnimatedViewPager

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
internal fun PostRegisterPager(modifier: Modifier = Modifier,navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val pageWidth = screenWidth.dp
    val drawables =
        listOf(
            R.drawable.ob_1,
            R.drawable.ob_2,
            R.drawable.ob_3,
            R.drawable.ob_4,
        )

    ComposePagerTheme {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                AnimatedViewPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        ,
                    pageSize = pageWidth, // Page is in square shape
                    drawables = drawables,
                )
            }
        }
    }
}
