package com.khana.stayfit.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData
import com.khana.stayfit.screens.CompleteProfile
import com.khana.stayfit.screens.CreateAccount
import com.khana.stayfit.screens.LoginAccount
import com.khana.stayfit.screens.OnBoardingScreen
import com.khana.stayfit.screens.PostRegisterPager
import com.khana.stayfit.screens.SplashScreen

private fun generateMockLineDataList(): List<LineData> {
    return listOf(
        LineData(0F, "Jan"),
        LineData(10F, "Feb"),
        LineData(05F, "Mar"),
        LineData(50F, "Apr"),
        LineData(55F, "May"),
        LineData(03F, "June"),
        LineData(9F, "July"),
        LineData(40F, "Aug"),
        LineData(60F, "Sept"),
        LineData(33F, "Oct"),
        LineData(11F, "Nov"),
    )
}

@Composable
fun a(){
    LineChart(
        dataCollection = ChartDataCollection(generateMockLineDataList()),
        modifier = Modifier
            .size(450.dp),
    )
}

@Composable
fun Navigation(){
     val navController = rememberNavController()
     NavHost(navController, startDestination = Screen.SplashScreen.route){
         composable(route = Screen.SplashScreen.route) {
               a()
         }
         composable(Screen.OnBoardingScreen.route) {
                OnBoardingScreen(navController)
         }
         composable(Screen.PostRegisterScreen.route) {
             PostRegisterPager(navController = navController)
         }
         composable(Screen.CreateAccountScreen.route) {
             CreateAccount(navController)
         }
         composable(Screen.CompleteProfile.route) {
             CompleteProfile(navController)
         }
         composable(Screen.LoginScreen.route) {
             LoginAccount(navController)
         }
     }
}

sealed class Screen(val route:String){
    data object LoginScreen:Screen("login_screen")
    data object CompleteProfile:Screen("complete_profile")
   data object SplashScreen:Screen("splash_screen")
   data object OnBoardingScreen:Screen("oboarding_screen")
   data object PostRegisterScreen:Screen("post_register_screen")
   data object  CreateAccountScreen:Screen("createaccount_screen")
}