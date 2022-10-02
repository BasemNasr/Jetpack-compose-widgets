package com.bn.saudimarche

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.bn.saudimarche.data.SharedPrefManager
import com.bn.saudimarche.presentation.navigation.AppNavigation
import com.bn.saudimarche.presentation.navigation.AppScreens
import com.bn.saudimarche.presentation.screens.main.MainScreen
import com.bn.saudimarche.presentation.screens.splash.SplashScreen
import com.bn.saudimarche.presentation.theme.SaudiMarcheTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    @OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberAnimatedNavController()
            SaudiMarcheTheme {
                SaudiMarcheApp(navController, this@MainActivity)
            }
        }
    }


    /*override fun onBackPressed() {
        if (navController.currentBackStackEntry?.destination?.route
            == AppScreens.HomeScreen.name
        ) {
            finish()
        } else super.onBackPressed()
    }*/

   /* private fun hideSystemUI() {
        //Hide the status bars
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        } else {
            window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }*/
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun SaudiMarcheApp(navController: NavHostController, mContext: Context) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppNavigation(
                navController,
                SharedPrefManager(mContext = mContext)
            )
        }
    }
}

