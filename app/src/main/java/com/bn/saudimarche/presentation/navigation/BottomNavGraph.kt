package com.bn.saudimarche.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bn.saudimarche.presentation.screens.main.mainScreens.CartScreen
import com.bn.saudimarche.presentation.screens.main.mainScreens.ExploreScreen
import com.bn.saudimarche.presentation.screens.main.mainScreens.OffersScreen
import com.bn.saudimarche.presentation.screens.main.mainScreens.ProfileScreen

@Composable
fun BottomNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreens.ExploreScreen.name
    ) {
        addExploreScreen(navController, this)

        addOfferScreen(navController, this)

        addCartScreen(navController, this)

        addProfileScreen(navController, this)

    }
}

private fun addExploreScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppScreens.ExploreScreen.name) {
        ExploreScreen(
            navController
        )
    }
}

private fun addOfferScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppScreens.OffersScreen.name) {
        OffersScreen(
            navController
        )
    }
}

private fun addCartScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppScreens.CartScreen.name) {
        CartScreen(
            navController
        )
    }
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppScreens.ProfileScreen.name) {
        ProfileScreen(
            navController
        )
    }
}