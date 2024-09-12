package com.khana.stayfit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khana.stayfit.screens.CreateAccount
import com.khana.stayfit.screens.OnBoardingScreen
import com.khana.stayfit.screens.PostRegisterPager
import com.khana.stayfit.screens.SplashScreen

@Composable
fun Navigation(){
     val navController = rememberNavController()
     NavHost(navController, startDestination = Screen.SplashScreen.route){
         composable(route = Screen.SplashScreen.route) {
                SplashScreen(navController)
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
     }
}

sealed class Screen(val route:String){
   data object SplashScreen:Screen("splash_screen")
   data object OnBoardingScreen:Screen("oboarding_screen")
   data object PostRegisterScreen:Screen("post_register_screen")
   data object  CreateAccountScreen:Screen("createaccount_screen")
}