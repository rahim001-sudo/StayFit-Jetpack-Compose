package com.khana.stayfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.navigation.Screen
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2A2C38
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color424456
import com.khana.stayfit.ui.theme.color494345
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorB6B4C1
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController?=null){
    LaunchedEffect(true) {
        delay(3000)
            navController?.navigate(Screen.OnBoardingScreen.route)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color2A2C38)){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    stringResource(R.string.stay), fontFamily = AppFont.fontFamily, fontWeight = FontWeight.Bold,
                    color = color983BCB, fontSize = 45.sp)
                Spacer(modifier = Modifier
                    .wrapContentSize()
                    .width(10.dp))
                Text(
                    text = stringResource(R.string.fit), fontFamily = AppFont.fontFamily, fontWeight = FontWeight.Bold,
                    color = Color.White, fontSize = 45.sp)
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.everybody_can_train),
                fontWeight = FontWeight.Medium,
                color = colorB6B4C1,
                fontSize = 15.sp,
                fontFamily = AppFont.fontFamily
            )
        }

        GradientButton(
            text = stringResource(R.string.get_started),
            gradient = Brush.horizontalGradient(listOf(
                color983BCB,
                color4023D7
            ).reversed()),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    20.dp
                )
        ) {
            navController?.navigate(Screen.OnBoardingScreen.route)
        }
    }
}