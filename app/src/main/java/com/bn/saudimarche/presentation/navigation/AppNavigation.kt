package com.bn.saudimarche.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.bn.saudimarche.data.SharedPrefManager
import com.bn.saudimarche.presentation.screens.auth.LoginScreen
import com.bn.saudimarche.presentation.screens.auth.OtpScreen
import com.bn.saudimarche.presentation.screens.auth.RegisterScreen
import com.bn.saudimarche.presentation.screens.intro.IntroScreen
import com.bn.saudimarche.presentation.screens.main.MainScreen
import com.bn.saudimarche.presentation.screens.splash.SplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    navController: NavHostController,
    mSharedPrefManager: SharedPrefManager
) {
    //SplashScreen
    AnimatedNavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.name
    ) {
        //SplashScreen
        composable(
            route = AppScreens.SplashScreen.name,
            enterTransition = { _, _ -> slideInHorizontally(animationSpec = tween(500)) },
            exitTransition = { _, _ -> slideOutHorizontally(animationSpec = tween(500)) },
        ) {
            SplashScreen(navController)
        }
        //Intro Screen
        composable(
            route = AppScreens.IntroScreen.name,
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }
        ) {
            IntroScreen(navController)
        }
        //Register Screen
        composable(
            route = AppScreens.RegisterScreen.name,
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }
        ) {
            RegisterScreen(navController)
        }
        //Otp Screen
        composable(
            route = AppScreens.OtpScreen.name,
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }
        ) {
            OtpScreen(navController)
        }
        //Login Screen
        composable(
            route = AppScreens.LoginScreen.name,
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }
        ) {
            LoginScreen(navController)
        }
        //HomeScreen
        composable(
            route = AppScreens.HomeScreen.name,
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }
        ) {
            MainScreen(navController)
        }

    }
}

