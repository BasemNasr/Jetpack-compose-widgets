package com.bn.saudimarche.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.bn.saudimarche.data.SharedPrefManager
import com.bn.saudimarche.presentation.screens.auth.LoginScreen
import com.bn.saudimarche.presentation.screens.auth.OtpScreen
import com.bn.saudimarche.presentation.screens.auth.RegisterScreen
import com.bn.saudimarche.presentation.screens.intro.IntroScreen
import com.bn.saudimarche.presentation.screens.main.MainScreen
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
        startDestination = AppScreens.HomeScreen.name
    ) {
        //SplashScreen
        composable(
            route = AppScreens.SplashScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            MainScreen(navController)
        }
        //Intro Screen
        composable(
            route = AppScreens.IntroScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            IntroScreen(navController)
        }
        //Register Screen
        composable(
            route = AppScreens.RegisterScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            RegisterScreen(navController)
        }
        //Otp Screen
        composable(
            route = AppScreens.OtpScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            OtpScreen(navController)
        }
        //Login Screen
        composable(
            route = AppScreens.LoginScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            LoginScreen(navController)
        }


        //HomeScreen
        composable(
            route = AppScreens.HomeScreen.name,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            }
        ) {
            MainScreen(navController)
        }

    }
}

