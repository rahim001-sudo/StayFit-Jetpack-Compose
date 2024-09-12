package com.khana.stayfit.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.model.OnBoardingModel
import com.khana.stayfit.navigation.Screen
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2a2c38
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorB6B4C1
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(navController: NavController?=null) {
    val lstOnBoarding = listOf(
        OnBoardingModel(
            R.drawable.ob_1,
            stringResource(R.string.track_your_goal),
            stringResource(R.string.don_t_worry_if_you_have_trouble_determining_your_goals_we_can_help_you_determine_your_goals_and_track_your_goals)
        ),
        OnBoardingModel(
            R.drawable.ob_2,
            stringResource(R.string.get_burn),
            stringResource(R.string.let_s_keep_burning_to_achive_yours_goals_it_hurts_only_temporarily_if_you_give_up_now_you_will_be_in_pain_forever)
        ),
        OnBoardingModel(
            R.drawable.ob_3,
            stringResource(R.string.eat_well),
            stringResource(R.string.let_s_start_a_healthy_lifestyle_with_us_we_can_determine_your_diet_every_day_healthy_eating_is_fun)
        ),
        OnBoardingModel(
            R.drawable.ob_4,
            stringResource(R.string.improve_sleep_quality),
            stringResource(R.string.improve_the_quality_of_your_sleep_with_us_good_quality_sleep_can_bring_a_good_mood_in_the_morning)
        )
    )
    val coroutineScope = rememberCoroutineScope()
    val option = BitmapFactory.Options()
    val progress =  remember { mutableFloatStateOf(0.0f) }
    option.outWidth  = 30
    option.outHeight = 30
    option.inPreferredConfig = Bitmap.Config.ARGB_8888
    val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources,
        R.drawable.ic_arrow_right,
        option
    ).asImageBitmap()
    val pagerState = rememberPagerState(pageCount = { 4 })
    Box {
        HorizontalPager(state = pagerState) {
            HorizontalPager(
                state = pagerState, modifier = Modifier
                    .fillMaxWidth()

            ) { page ->
                OnBoarding(model = lstOnBoarding[page])
            }
        }
        Box (modifier = Modifier.align(Alignment.BottomEnd)) {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .drawWithContent {
                        drawCircle(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    color983BCB,
                                    color4023D7
                                )
                            ), radius = (drawContext.size.width * 0.7f) / 2
                        )

                        drawImage(
                            image = bitmap,
                            topLeft = Offset(
                                (drawContext.size.width / 2f) - 18,
                                (drawContext.size.width / 2f) - 18
                            )
                        )
                        drawContent()
                    }
                    .clickable {
                        coroutineScope.launch {
                            if (pagerState.currentPage == lstOnBoarding.size - 1) {
                                navController?.navigate(Screen.CreateAccountScreen.route)
                            }
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            progress.floatValue += 0.25f
                        }
                    },
                color = Color.White,
                progress = { progress.floatValue}
            )
        }

    }

}


@Composable
fun OnBoarding(model: OnBoardingModel) {
    Box(
        modifier = Modifier
            .background(color = color2a2c38)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

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



