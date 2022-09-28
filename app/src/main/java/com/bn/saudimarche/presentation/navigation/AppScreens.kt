package com.bn.saudimarche.presentation.navigation


enum class AppScreens {
    SplashScreen,
    IntroScreen,
    RegisterScreen,
    LoginScreen,
    OtpScreen,
    HomeScreen;
    companion object{
        fun fromRoute(route:String): AppScreens
                = when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            IntroScreen.name -> IntroScreen
            RegisterScreen.name -> RegisterScreen
            LoginScreen.name -> LoginScreen
            OtpScreen.name -> OtpScreen
            HomeScreen.name -> HomeScreen
            null-> HomeScreen
            else-> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}