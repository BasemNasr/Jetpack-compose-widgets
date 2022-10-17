package com.bn.saudimarche.presentation.screens.main.mainScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.data.model.product.ProductModel
import com.bn.saudimarche.presentation.theme.BACKGROUND_COLOR

@Composable
fun OffersScreen(navController: NavController?=null) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color =BACKGROUND_COLOR)
                .fillMaxWidth()
                .fillMaxHeight()
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val searchTextState = remember { mutableStateOf(TextFieldValue("")) }
            SearchView(searchTextState)
            var latestAdditions = listOf(
                ProductModel(
                    1,
                    "Product 1",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "500",
                    "700",
                    "Car Care",
                    false,
                    "new"
                ),
                ProductModel(
                    2,
                    "Product 2",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "300",
                    "400",
                    "Car Care",
                    false,
                    "new"
                ),
                ProductModel(
                    3,
                    "Product 3",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "500",
                    "800",
                    "Car Care",
                    false,
                    "20% off"
                ),
                ProductModel(
                    4,
                    "Product 4",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "100",
                    "200",
                    "Car Care",
                    false,
                    "30% off"
                ),
                ProductModel(
                    5,
                    "Product 5",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "99",
                    "150",
                    "Car Care",
                    false
                ),
                ProductModel(
                    6,
                    "Product 6",
                    "https://i.ibb.co/r0BSX4p/cars.jpg",
                    "700",
                    "900",
                    "Car Care",
                    false
                )
            )
            latestAdditionContent(latestAdditions, modifier = Modifier.fillMaxHeight())

        }
    }
}
