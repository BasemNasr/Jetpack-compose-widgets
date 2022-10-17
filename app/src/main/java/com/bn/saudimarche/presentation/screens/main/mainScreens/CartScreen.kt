package com.bn.saudimarche.presentation.screens.main.mainScreens

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bn.saudimarche.R
import com.bn.saudimarche.data.model.product.ProductModel
import com.bn.saudimarche.presentation.theme.*
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
@Preview
fun CartScreen(navController: NavController? = null) {
    Scaffold(topBar = {
    },
        floatingActionButton = {

        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(
                modifier = Modifier
                    .background(color = BACKGROUND_COLOR)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(id = R.string.cart), style = Typography.h5,
                    fontSize = 30.sp,
                    color = textColorBrown
                )


                var latestAdditions = listOf(
                    ProductModel(
                        1,
                        "Product 1",
                        "https://i.ibb.co/r0BSX4p/cars.jpg",
                        "500",
                        "700",
                        "Car Care",
                        false
                    ),
                    ProductModel(
                        2,
                        "Product 2",
                        "https://i.ibb.co/r0BSX4p/cars.jpg",
                        "300",
                        "400",
                        "Car Care",
                        false
                    ),
                    ProductModel(
                        3,
                        "Product 3",
                        "https://i.ibb.co/r0BSX4p/cars.jpg",
                        "500",
                        "800",
                        "Car Care",
                        false
                    ),
                    ProductModel(
                        4,
                        "Product 4",
                        "https://i.ibb.co/r0BSX4p/cars.jpg",
                        "100",
                        "200",
                        "Car Care",
                        false
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
                cartItems(latestAdditions, modifier = Modifier.fillMaxHeight())


            }
        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun cartItems(list: List<ProductModel>? = null, modifier: Modifier = Modifier.height(400.dp)) {
    val notesList = remember {
        list!!.toMutableStateList()
    }
    LazyColumn(modifier = modifier,content = {
        items(notesList?.size!!) { index ->
            var product = notesList[index]
            val dismissState = rememberDismissState()
            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                Log.v("PName","${product.name}")
                notesList.remove(product)
            }
            SwipeToDismiss(
                state = dismissState,
                modifier = Modifier
                    .padding(vertical = Dp(1f)),
                directions = setOf(
                    DismissDirection.EndToStart
                ),
                dismissThresholds = { direction ->
                    FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f)
                },
                background = {
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.Default -> BACKGROUND_COLOR
                            else -> RED_COLOR
                        }
                    )
                    val alignment = Alignment.CenterEnd
                    val icon = Icons.Default.Delete

                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = Dp(20f)),
                        contentAlignment = alignment
                    ) {
                        Icon(
                            icon,
                            contentDescription = "Delete Icon",
                            modifier = Modifier.scale(scale)
                        )
                    }
                },
                dismissContent = {

                    Card(
                        elevation = animateDpAsState(
                            if (dismissState.dismissDirection != null) 4.dp else 0.dp
                        ).value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        CartItem(product)
                    }
                }
            )
        }
    }
    )

}

@Composable
fun CartItem(product: ProductModel) {
    val productQuantity = remember { mutableStateOf(product.quantity) }

    Row(modifier = Modifier.wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically) {

        Card(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(4.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(15.dp),
        ) {
            Image(
                painter = rememberImagePainter(data = "${product.image}"),
                "",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "${product.name}",
                fontSize = 24.sp,
                color = textColorBrown,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 8.dp, top = 0.dp),
                fontFamily = somarSemiBold,
                maxLines = 1
            )


            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 0.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 0.dp)
                ) {
                    Text(
                        text = "${product.price} ${stringResource(id = R.string.currency_)}",
                        style = Typography.body2,
                        color = textColorBrown
                    )

                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "${product.price_before_discount} ${stringResource(id = R.string.currency_)}",
                        style = Typography.body2,
                        color = textColorBrown,
                        textDecoration = TextDecoration.combine(
                            listOf(
                                TextDecoration.LineThrough
                            )
                        )
                    )

                }
            }
            //Count
            Row(
                modifier = Modifier
                    .width(80.dp)
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = TEXT_FILED_BACK_GROUND
                    )
                    .border(
                        width = 1.dp,
                        color = TEXT_FILED_BORDER_COLOR,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    stringResource(id = R.string.notifications),
                    tint = textColorBrown,
                    modifier = Modifier.clickable {
                        if(product.quantity!=999){
                            product.quantity = (product.quantity?:0) +1
                            productQuantity.value = product.quantity
                        }
                    }
                )

                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                        .wrapContentWidth(),
                    maxLines = 1,
                    text = "${productQuantity.value}",
                    style = Typography.h2,
                    color = textColorBrown,
                )

                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    stringResource(id = R.string.notifications),
                    tint = textColorBrown,
                    modifier = Modifier.clickable {
                        if(product.quantity!=0){
                            product.quantity = (product.quantity?:0) -1
                            productQuantity.value = product.quantity
                        }

                    }
                )
            }

        }





    }

}





