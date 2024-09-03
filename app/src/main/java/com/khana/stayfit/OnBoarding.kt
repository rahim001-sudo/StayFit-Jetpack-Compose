package com.khana.stayfit

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.khana.stayfit.model.OnBoardingModel
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2a2c38
import com.khana.stayfit.ui.theme.color7030D1
import com.khana.stayfit.ui.theme.colorB6B4C1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


val lstOnBoarding = listOf(
    OnBoardingModel(
        R.drawable.ob_1, "Track Your Goal",
        "Don't worry if you have trouble determining your goals, We can help you determine your goals and track your goals"
    ),
    OnBoardingModel(
        R.drawable.ob_2,
        "Get Burn",
        "Let’s keep burning, to achive yours goals, it hurts only temporarily, if you give up now you will be in pain forever"
    ),
    OnBoardingModel(
        R.drawable.ob_3,
        "Eat Well",
        "Let's start a healthy lifestyle with us, we can determine your diet every day. healthy eating is fun"
    ),
    OnBoardingModel(
        R.drawable.ob_4,
        "Improve Sleep  Quality",
        "Improve the quality of your sleep with us, good quality sleep can bring a good mood in the morning"
    )
)

@Preview(showBackground = true)
@Composable
@OptIn(ExperimentalFoundationApi::class)
fun s() {
    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(pageCount = { 4 })
    Box {

        HorizontalPager(state = pagerState) {
            HorizontalPager(
                state = pagerState, modifier = Modifier
                    .fillMaxWidth()

            ) { page ->
                OnBoarding(model = lstOnBoarding[page], state = pagerState)
            }



        }

        Button(
            modifier = Modifier.align(Alignment.BottomEnd).padding(
                20.dp
            ),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = color7030D1
            ),
            onClick = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage+1)
            }

            }) {
            Image(
                modifier = Modifier.height(20.dp).width(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription ="Arrow"
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("NotConstructor")
@Composable
fun OnBoarding(model: OnBoardingModel, state: PagerState) {
    Box(
        modifier = Modifier
            .background(color = color2a2c38)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val coroutineScope = rememberCoroutineScope()

        Column {
            Image(
                painter = painterResource(id = model.image), contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = model.title,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 15.dp,
                    top = 25.dp
                ),
                fontFamily = AppFont.fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(20f, TextUnitType.Sp)
            )
            Text(
                text = model.subTitle,
                modifier = Modifier.padding(
                    start = 15.dp,
                    top = 10.dp, end = 20.dp
                ),
                color = colorB6B4C1,
                fontFamily = AppFont.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = TextUnit(14f, TextUnitType.Sp)
            )


        }

    }
}



