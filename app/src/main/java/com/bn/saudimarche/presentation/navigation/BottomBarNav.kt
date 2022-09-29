package com.bn.saudimarche.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.BACKGROUND_COLOR
import com.bn.saudimarche.presentation.theme.Typography
import com.bn.saudimarche.presentation.theme.textColorBrown

@Composable
fun BottomBarNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == null || currentRoute == AppScreens.LoginScreen.name) {
        return
    }
    BottomNavigation(
        modifier = Modifier
            .height(66.dp)
            .background(Color.Transparent)
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            ),
        backgroundColor = BACKGROUND_COLOR,
        contentColor = textColorBrown,
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val exploreSelected = currentRoute == AppScreens.ExploreScreen.name
            BottomNavigationItem(
                icon = {
//                    if (currentRoute != AppScreens.ExploreScreen.name)
                    Icon(
                        painter = painterResource(id = R.drawable.explore_icon),
                        stringResource(id = R.string.explore),
                        tint = textColorBrown
                    )
                },
                selected = exploreSelected,
                onClick = {
                    if (!exploreSelected) {
                        navController.navigate(AppScreens.ExploreScreen.name) {
                            popUpTo(AppScreens.ExploreScreen.name) { inclusive = true }
                        }
                    }
                },
                label = {
                    if (currentRoute == AppScreens.ExploreScreen.name)
                        Text(
                            text = stringResource(id = R.string.explore),
                            modifier = Modifier.padding(2.dp),
                            style = Typography.h4,
                            color = textColorBrown
                        )
                    else
                        Text(text = "")
                },
            )

            val offersSelected = currentRoute == AppScreens.OffersScreen.name
            BottomNavigationItem(
                icon = {
//                    if (currentRoute != AppScreens.OffersScreen.name)
                    Image(
                        painter = painterResource(id = R.drawable.offers_icon),
                        contentDescription = stringResource(id = R.string.offers),
                    )
                },
                selected = offersSelected,
                onClick = {
                    if (!offersSelected) {
                        navController.navigate(AppScreens.OffersScreen.name) {
                            popUpTo(AppScreens.OffersScreen.name) { inclusive = true }
                        }
                    }
                },
                label = {
                    if (currentRoute == AppScreens.OffersScreen.name)
                        Text(
                            text = stringResource(id = R.string.offers),
                            modifier = Modifier.padding(2.dp),
                            style = Typography.h4,
                            color = textColorBrown
                        )
                    else
                        Text(text = "")

                }
            )


            val cartSelected = currentRoute == AppScreens.CartScreen.name
            BottomNavigationItem(
                icon = {
//                    if (currentRoute != AppScreens.CartScreen.name)
                    Image(
                        painter = painterResource(id = R.drawable.cart_icon),
                        contentDescription = stringResource(id = R.string.offers),
                    )
                },
                selected = cartSelected,
                onClick = {
                    if (!cartSelected) {
                        navController.navigate(AppScreens.CartScreen.name) {
                            popUpTo(AppScreens.CartScreen.name) { inclusive = true }
                        }
                    }
                },
                label = {
                    if (currentRoute == AppScreens.CartScreen.name)
                        Text(
                            text = stringResource(id = R.string.cart),
                            modifier = Modifier.padding(2.dp),
                            style = Typography.h4,
                            color = textColorBrown
                        )
                    else
                        Text(text = "")

                }
            )

            val profileSelected = currentRoute == AppScreens.ProfileScreen.name
            BottomNavigationItem(
                icon = {
//                    if (currentRoute != AppScreens.ProfileScreen.name)
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = stringResource(id = R.string.my_account),
                    )
                },
                selected = profileSelected,
                onClick = {
                    if (!profileSelected) {
                        navController.navigate(AppScreens.ProfileScreen.name) {
                            popUpTo(AppScreens.ProfileScreen.name) { inclusive = true }
                        }
                    }
                },
                label = {
                    if (currentRoute == AppScreens.ProfileScreen.name)
                        Text(
                            text = stringResource(id = R.string.my_account),
                            modifier = Modifier.padding(2.dp),
                            style = Typography.h4,
                            color = textColorBrown
                        )
                    else
                        Text(text = "")
                }
            )


        }

    }
}