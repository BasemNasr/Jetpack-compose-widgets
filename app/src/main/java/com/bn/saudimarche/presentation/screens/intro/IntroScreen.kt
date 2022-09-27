package com.bn.saudimarche.presentation.screens.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.APP_GREEN_COLOR
import com.bn.saudimarche.presentation.theme.Typography


@Composable
fun IntroScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(APP_GREEN_COLOR)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = Typography.h4
        )


    }
}

