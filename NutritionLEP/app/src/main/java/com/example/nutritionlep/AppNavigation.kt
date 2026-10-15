package com.example.nutritionlep

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val SPLASH   = "splash"
    const val LANGUAGE = "language"
    const val WELCOME  = "welcome"
    const val LOGIN    = "login"
    const val REGISTER = "register"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onFinished = {
                    navController.navigate(Routes.LANGUAGE) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
               }
            )
        }

        composable(Routes.LANGUAGE) {
            LanguageSelectionScreen(
                onLanguageSelected = { navController.navigate(Routes.WELCOME) }
            )
        }
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onRegisterClick = { navController.navigate(Routes.REGISTER) },
                onLoginClick    = { navController.navigate(Routes.LOGIN) }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen()
        }
        composable(Routes.REGISTER) {
            RegisterScreen()
        }
    }
}