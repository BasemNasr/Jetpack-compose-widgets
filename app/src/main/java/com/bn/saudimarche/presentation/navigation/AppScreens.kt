package com.bn.saudimarche.presentation.navigation


enum class AppScreens {
    SplashScreen,
    IntroScreen,
    HomeScreen;
    companion object{
        fun fromRoute(route:String): AppScreens
                = when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            IntroScreen.name -> IntroScreen
            HomeScreen.name -> HomeScreen
            null-> HomeScreen
            else-> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}