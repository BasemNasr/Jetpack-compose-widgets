package com.bn.saudimarche.presentation.screens.main.mainScreens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bn.saudimarche.R
import com.bn.saudimarche.data.model.categories.CategoryModel
import com.bn.saudimarche.data.model.product.ProductModel
import com.bn.saudimarche.presentation.theme.*
import com.bn.saudimarche.presentation.widgets.CounterCircle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun ExploreScreen(navController: NavController? = null) {

    Scaffold(topBar = { },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                backgroundColor = textColorBrown,
                contentColor = Purple700
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.gift),
                     "Prizes"
                )

            }
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
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                val textState = remember { mutableStateOf(TextFieldValue("")) }
                homeTopBar()
                SearchView(textState)
                AutoSliding()
                CategoriesList(
                    firstList =
                    listOf(
                        CategoryModel(
                            4,
                            "Electronics",
                            "https://i.ibb.co/gDMx2Qw/Consumer-Electronics.jpg"
                        )
                    ),
                    secondList =
                    listOf(
                        CategoryModel(1, "Cafe", "https://i.ibb.co/dGWdf0w/cafe.jpg"),
                        CategoryModel(2, "Cars", "https://i.ibb.co/r0BSX4p/cars.jpg"),
                        CategoryModel(3, "Clothes", "https://i.ibb.co/1Rnm0Yc/clothes.jpg"),
                        CategoryModel(5, "Resturants", "https://i.ibb.co/QN6ZDV2/resturants.jpg"),
                        CategoryModel(6, "Shoes", "https://i.ibb.co/kB5fFr1/shoses.jpg"),
                    )
                )
                latestTitle()
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
                latestAdditionContent(latestAdditions)

            }
        }

    }


}


@Composable
private fun homeTopBar() {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box() {
            Icon(
                painter = painterResource(id = R.drawable.notifications_item),
                stringResource(id = R.string.notifications),
                tint = textColorBrown
            )
            CounterCircle(text = "1")
        }
        Image(
            painter = painterResource(id = R.drawable.main_top_logo),
            stringResource(id = R.string.notifications),
        )
        Image(
            painter = painterResource(id = R.drawable.menu_icon),
            stringResource(id = R.string.notifications),
        )
    }
}


@Composable
private fun latestTitle() {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.newest_added), style = Typography.h5,
            color = textColorBrown
        )
        Text(
            text = stringResource(id = R.string.show_all), style = Typography.body1,
            color = textColorBrown
        )
    }
}


@Composable
@Preview("latestAdditionContent")
private fun latestAdditionContent(list: List<ProductModel>? = null) {
    LazyVerticalGrid(
        modifier = Modifier.height(400.dp),
        columns = GridCells.Adaptive(168.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 2.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list?.size!!) { index ->
                var product = list[index]
                Column(modifier = Modifier.wrapContentHeight()) {
                    Card(
                        backgroundColor = Color.Transparent,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        elevation = 0.dp,
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = "${product.image}"),
                            "",
                            modifier = Modifier
                                .height(240.dp)
                                .width(170.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Text(
                        text = "${product.name}",
                        fontSize = 24.sp,
                        color = textColorBrown,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        fontFamily = somarSemiBold,
                        maxLines = 1
                    )
                    Text(
                        text = "${product.owner_name}",
                        fontSize = 24.sp,
                        color = TextColorSilverHint,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 8.dp),
                        fontFamily = somarRegular,
                        maxLines = 1
                    )

                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 0.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        val likeState = remember { mutableStateOf(list[index].isLike) }

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
                        Image(
                            painter = if (likeState.value == true) painterResource(id = R.drawable.liked) else painterResource(
                                id = R.drawable.not_like
                            ),
                            "Like",
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .clickable {
                                    likeState.value = !likeState.value!!
                                },
                            contentScale = ContentScale.Fit
                        )


                    }

                }

            }
        }
    )
}


@ExperimentalPagerApi
@Composable
fun AutoSliding() {
    val pagerState = rememberPagerState(
        initialPage = 2
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(1200)
            )
        }
    }

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 0.dp),
            count = 10
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 15.dp, 0.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(180.dp)
                        .background(Color.LightGray)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Image(
                        painter = painterResource(
                            id = when (page) {
                                1 -> R.drawable.slider_place_holder
                                2 -> R.drawable.slider_place_holder
                                3 -> R.drawable.slider_place_holder
                                4 -> R.drawable.slider_place_holder
                                5 -> R.drawable.slider_place_holder
                                else -> R.drawable.slider_place_holder
                            }
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

    }
}


@Composable
fun SearchView(state: MutableState<TextFieldValue>) {

    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(45.dp)
            .wrapContentHeight()
            .fillMaxHeight()
            .background(shape = RoundedCornerShape(10.dp), color = TEXT_FILED_BACK_GROUND)
            .border(
                width = 1.dp,
                color = TEXT_FILED_BORDER_COLOR,
                shape = RoundedCornerShape(10.dp)
            ),
        textStyle = TextStyle(
            color = textColorBrown,
            fontWeight = FontWeight.Bold,
            fontFamily = somarRegular,
            fontSize = 16.sp
        ),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .padding(5.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = textColorBrown,
            cursorColor = textColorBrown,
            leadingIconColor = textColorBrown,
            trailingIconColor = textColorBrown,
            backgroundColor = BACKGROUND_COLOR,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),

        )
}


@Composable
@Preview("Categories")
fun CategoriesList(
    firstList: List<CategoryModel>? = null,
    secondList: List<CategoryModel>? = null
) {
    LazyRow(
        modifier = Modifier
            .wrapContentHeight()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item(key = "categories_section") {
            var item = CategoryModel(
                4,
                "Electronics",
                "https://i.ibb.co/gDMx2Qw/Consumer-Electronics.jpg"
            )
            HeaderCategory(item)
        }
        gridItems(
            data = secondList ?: arrayListOf(),
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier.padding(horizontal = 1.dp)
        ) { itemData ->
            CategoryItem(itemData)
        }
    }
}

@Composable
fun CategoryItem(itemData: CategoryModel) {
    Column(modifier = Modifier.padding(1.dp)) {
        Column(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = TEXT_FILED_BACK_GROUND
                )
                .border(
                    width = 1.dp,
                    color = TEXT_FILED_BORDER_COLOR,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
                .width(104.dp)
                .height(92.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = rememberImagePainter(data = "${itemData.image}"),
                "",
                modifier = Modifier
                    .height(70.dp)
                    .width(75.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "${itemData.name}", style = Typography.body1, color = textColorBrown)
        }
    }

}

@Composable
fun HeaderCategory(item: CategoryModel) {
    Column(
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = TEXT_FILED_BACK_GROUND
            )
            .border(
                width = 1.dp,
                color = TEXT_FILED_BORDER_COLOR,
                shape = RoundedCornerShape(10.dp)
            )
            .width(190.dp)
            .padding(10.dp)
            .height(210.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val painter =
            rememberImagePainter(data = "${item.image}")
        Image(
            modifier = Modifier
                .height(140.dp)
                .fillMaxHeight(),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds

        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "${item.name}", style = Typography.body1, color = textColorBrown)
    }
}


fun <T> LazyListScope.gridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val size = data.count()
    val rows = if (size == 0) 0 else 1 + (size - 1) / columnCount
    items(rows, key = { it.hashCode() }) { rowIndex ->
        Column(
            modifier = modifier
        ) {
            for (columnIndex in 0 until columnCount) {
                val itemIndex = rowIndex * columnCount + columnIndex
                if (itemIndex < size) {
                    Box(
                        propagateMinConstraints = true
                    ) {
                        itemContent(data[itemIndex])
                    }
                } else {
//                    Spacer(Modifier.weight(1F, fill = true))
                }
            }
        }
    }
}


