package com.bn.saudimarche.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.navigation.AppScreens
import com.bn.saudimarche.presentation.theme.BOLD_SILVER_BACKGROUND_COLOR
import com.bn.saudimarche.presentation.theme.TextColorSilverHint
import com.bn.saudimarche.presentation.theme.Typography
import com.bn.saudimarche.presentation.theme.textColorBrown
import com.bn.saudimarche.presentation.widgets.AppButton


@ExperimentalComposeUiApi
@Preview()
@Composable
fun OtpScreen(navController: NavController? = null) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(BOLD_SILVER_BACKGROUND_COLOR)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash_icon),
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp)
                    .padding(top = 60.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
                contentDescription = stringResource(id = R.string.app_name),
            )
            BoxOtpDataInputs(navController)
        }
    }
}

@ExperimentalComposeUiApi
@Preview("BoxLoginDataInputs")
@Composable
private fun BoxOtpDataInputs(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 10.dp, end = 10.dp)
            .wrapContentHeight()
            .background(White, shape = RoundedCornerShape(50.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.activate_account),
            modifier = Modifier.padding(10.dp),
            style = Typography.h5,
            color = textColorBrown
        )
        Text(
            text = stringResource(id = R.string.otp_hint),
            modifier = Modifier.padding(top = 10.dp, start = 10.dp,end=10.dp),
            style = Typography.body1,
            textAlign = TextAlign.Center,
            color = TextColorSilverHint
        )
        Text(
            text = "+2056565656",
            modifier = Modifier.padding(top = 10.dp),
            style = Typography.body1,
            textAlign = TextAlign.Center,
            color = textColorBrown
        )

        OtpNumbers()
        AppButton(
            modifier = Modifier
                .height(48.dp)
                .width(340.dp),
            text = stringResource(id = R.string.send_text),
            background = textColorBrown,
            textColor = Color.White,
            elevation = 0.dp
        ) {
            //call register api here
            navController?.navigate(AppScreens.HomeScreen.name)
        }
        Spacer(modifier = Modifier.height(40.dp))

    }
}

@Composable
fun OtpNumbers() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    var number4 by remember { mutableStateOf("") }
    var number5 by remember { mutableStateOf("") }

    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }
    val focusRequester5 = remember { FocusRequester() }

    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 40.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(end = 3.dp)
                .size(width = 45.dp, height = 60.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(BOLD_SILVER_BACKGROUND_COLOR, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number1,
                maxLines = 1,
                onValueChange = {
                    number1 = it
                    if (it.length == 1){
                        focusRequester2.requestFocus()
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .focusRequester(focusRequester1),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColorBrown,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }

        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .padding(end = 3.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(BOLD_SILVER_BACKGROUND_COLOR, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number2,
                maxLines = 1,

                onValueChange = {
                    number2 = it
                    if (it.length == 1) {
                        focusRequester3.requestFocus()
                    }
                    if(it.isEmpty()){
                        focusRequester1.requestFocus()
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .focusRequester(focusRequester2),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColorBrown,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }
        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .padding(end = 3.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(BOLD_SILVER_BACKGROUND_COLOR, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number3,
                maxLines = 1,
                onValueChange = {
                    number3 = it
                    if (it.length == 1) {
                        focusRequester4.requestFocus()
                    }
                    if(it.isEmpty()){
                        focusRequester2.requestFocus()
                    }

                },
                modifier = Modifier
                    .width(50.dp)
                    .focusRequester(focusRequester3),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColorBrown,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }
        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .padding(end = 3.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(BOLD_SILVER_BACKGROUND_COLOR, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number4,
                maxLines = 1,
                onValueChange = {
                    number4 = it
                    if (it.length == 1) {
                        focusRequester5.requestFocus()
                    }
                    if(it.isEmpty()){
                        focusRequester3.requestFocus()
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .focusRequester(focusRequester4),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColorBrown,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }
        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .padding(end = 3.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(BOLD_SILVER_BACKGROUND_COLOR, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number5,
                maxLines = 1,
                onValueChange = {
                    if (it.length <= 1) number5 = it
                    number5 = it
                    if (it.length == 1) {
                        focusManager.clearFocus()
                    }
                    if(it.isEmpty()){
                        focusRequester4.requestFocus()
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .focusRequester(focusRequester5),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColorBrown,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }


    }
}


