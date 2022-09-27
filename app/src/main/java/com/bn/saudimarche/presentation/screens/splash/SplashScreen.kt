package com.bn.saudimarche.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.navigation.AppScreens
import com.bn.saudimarche.presentation.theme.APP_GREEN_COLOR
import com.bn.saudimarche.presentation.theme.APP_GREEN_SECOND_COLOR
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                })
        )
        delay(2000L)
        navController.navigate(AppScreens.IntroScreen.name)
    })
    SplashAnimationWithContent()
}

@Composable
@Preview("Splash Screen")
fun SplashContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxWidth()
                .fillMaxHeight()
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(220.dp)
                    .padding(top = 8.dp),
                painter = painterResource(id = R.drawable.splash_icon),
                contentDescription = stringResource(id = R.string.app_name),
            )

        }
    }
}


@Composable
fun SplashAnimationWithContent() {
    val painter = painterResource(id = R.drawable.splash_bg)
    val angle1Y = remember {
        Animatable(-700f)
    }
    val angle2 = remember {
        Animatable(600f)
    }
    LaunchedEffect(angle1Y, angle2) {
        launch {
            angle1Y.animateTo(-2000f, animationSpec = tween(3000))
        }
        launch {
            angle2.animateTo(2000f, animationSpec = tween(3000))
        }
    }
    Surface(Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = null
        )
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                withTransform({
                    translate(left = 0f, top = angle1Y.value)
                    rotate(degrees = -45F)
                }) {
                    drawRoundRect(
                        color = APP_GREEN_COLOR,
                        size = Size(1200f, 4000f),
                        cornerRadius = CornerRadius(16.dp.toPx())
                    )
                }
                withTransform({
                    translate(left = -300F, top = angle2.value)
                    rotate(degrees = -45F)
                }) {
                    drawRoundRect(
                        color = APP_GREEN_SECOND_COLOR,
                        size = Size(1200f, 4000f),
                        cornerRadius = CornerRadius(16.dp.toPx())
                    )
                }
            }
        )
    }


}