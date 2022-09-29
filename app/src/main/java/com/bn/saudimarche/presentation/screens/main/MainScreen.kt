package com.bn.saudimarche.presentation.screens.main


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bn.saudimarche.presentation.navigation.BottomBarNav
import com.bn.saudimarche.presentation.navigation.BottomNavGraph


@Preview("Hello")
@Composable
fun MainScreen(navController: NavController? = null) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBarNav(navController = bottomNavController)
        }
    ) { paddingValues ->
        BottomNavGraph(
            modifier = Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            ),
            navController = bottomNavController
        )
    }
}







