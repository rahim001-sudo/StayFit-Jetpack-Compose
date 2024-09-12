package com.khana.stayfit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.ComposePagerTheme
import com.khana.stayfit.components.AnimatedViewPager
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2A2C38
import com.khana.stayfit.ui.theme.color36343A
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color8E67F3
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorB6B4C1


@Composable
internal fun PostRegisterPager(modifier: Modifier = Modifier,navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val pageWidth = screenWidth.dp
    val drawables =
        listOf(
            R.drawable.img_goal_1,
            R.drawable.img_goal_2,
            R.drawable.img_goal_3,
        )

    ComposePagerTheme {
        Surface(
            modifier = modifier,
            color = color2A2C38,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(Modifier.height(20.dp))
                Text("What is your goal ?",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = AppFont.fontFamily,
                    fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(15.dp))
                Text("it will help us to choose a best program for you",
                    fontFamily = AppFont.fontFamily,
                    color = colorB6B4C1,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 100.dp),
                    fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(30.dp))
                AnimatedViewPager(
                    modifier = Modifier
                        .fillMaxWidth(),
                    pageSize = pageWidth, // Page is in square shape
                    drawables = drawables,
                )
                Spacer(modifier = Modifier.height(50.dp))
                GradientButton(
                    "Confirm",
                    gradient = Brush.horizontalGradient(
                        listOf(
                            color983BCB,
                            color4023D7
                        ).reversed()
                    ),
                    modifier = Modifier.fillMaxWidth().padding(
                        horizontal = 30.dp,
                        vertical = 20.dp
                    )
                )
            }
        }
    }
}
