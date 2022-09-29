package com.bn.saudimarche.presentation.screens.main.mainScreens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.ImagePainter.State.Empty.painter
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.*
import com.bn.saudimarche.presentation.widgets.CounterCircle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import java.util.*
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun ExploreScreen(navController: NavController? = null) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color = BACKGROUND_COLOR)
                .fillMaxWidth()
                .fillMaxHeight()
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val textState = remember { mutableStateOf(TextFieldValue("")) }
            homeTopBar()
            SearchView(textState)
//            ItemList(state = textState)
            AutoSliding()
            //Categories

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                        .weight(0.4f)
                        .padding(10.dp)
                        .height(190.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        modifier = Modifier
                            .height(140.dp)
                            .fillMaxHeight(),
                        painter = painterResource(id = R.drawable.slider_place_holder),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight

                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "الاتصالات وملحقاتها", style = Typography.body1)
                }

                Spacer(modifier = Modifier.width(4.dp))


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
                        .weight(0.5f)
                        .padding(10.dp)
                        .height(190.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.slider_place_holder),
                        "",
                    )
                    Text(text = "الاتصالات وملحقاتها", style = Typography.body1)
                }




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


@ExperimentalPagerApi
@Composable
fun AutoSliding() {
    val pagerState = rememberPagerState(
        pageCount = 10,
        initialOffscreenLimit = 2
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
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
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
//                val natural = natural[page]
                Box(
                    modifier = Modifier
                        .height(180.dp)
                        .background(Color.LightGray)
                        .align(Alignment.Center)
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
fun ItemList(state: MutableState<TextFieldValue>) {
    val items by remember { mutableStateOf(listOf("Drink water", "Walk")) }

    var filteredItems: List<String>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text
        filteredItems = if (searchedText.isEmpty()) {
            items
        } else {
            val resultList = ArrayList<String>()
            for (item in items) {
                if (item.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(item)
                }
            }
            resultList
        }
        items(filteredItems) { filteredItem ->
            ItemListItem(
                ItemText = filteredItem,
                onItemClick = { /*Click event code needs to be implement*/
                }
            )
        }

    }
}


@Composable
fun ItemListItem(ItemText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(ItemText) })
            .background(colorResource(id = R.color.purple_700))
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = ItemText, fontSize = 18.sp, color = Color.White)
    }
}


