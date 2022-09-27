package com.bn.saudimarche.presentation.screens.intro

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.APP_GREEN_COLOR
import com.bn.saudimarche.presentation.theme.CIRCLE_COLOR
import com.bn.saudimarche.presentation.theme.Typography


@Preview("Hello")
@Composable
fun IntroScreen(navController: NavController?=null) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .wrapContentHeight()
            .background(APP_GREEN_COLOR)
    ) {
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                withTransform({
                    translate( top = -1000f)
                    rotate(degrees = -45F)
                    scale(40f,40f)
                }) {
                    drawCircle(
                        color = CIRCLE_COLOR,
                        radius = 20f
                    )
                }
            }
        )
       Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
        ) {

           Image(
               painter = painterResource(id = R.drawable.add_cart),
               modifier = Modifier.padding(20.dp),
               contentDescription = null
           )

        }

    }
}

