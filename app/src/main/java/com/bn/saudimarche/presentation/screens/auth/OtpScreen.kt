package com.bn.saudimarche.presentation.screens.auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.BOLD_SILVER_BACKGROUND_COLOR
import com.bn.saudimarche.presentation.theme.TextColorSilverHint
import com.bn.saudimarche.presentation.theme.Typography
import com.bn.saudimarche.presentation.theme.textColorBrown
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
            BoxOtpDataInputs()
        }
    }
}

@ExperimentalComposeUiApi
@Preview("BoxLoginDataInputs")
@Composable
private fun BoxOtpDataInputs() {
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
            text = stringResource(id = R.string.welcome_back),
            modifier = Modifier.padding(10.dp),
            style = Typography.h5,
            color = textColorBrown
        )
        Text(
            text = stringResource(id = R.string.login_hint),
            modifier = Modifier.padding(top = 10.dp),
            style = Typography.body1,
            color = TextColorSilverHint
        )

        OtpNumbers()
//        PinInput(){
//            Log.d("Resulttt",it)
//        }
    }
}

@Composable
fun OtpNumbers() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    var number4 by remember { mutableStateOf("") }
    var number5 by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(TextColorSilverHint, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number1,
                maxLines = 1,
                onValueChange = {
                    if (it.length <= 1) number1 = it
                },
                modifier = Modifier.width(50.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = White,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .size(width = 45.dp, height = 60.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.surface)
                .background(TextColorSilverHint, shape = RoundedCornerShape(10.dp)),
        ) {
            TextField(
                value = number1,
                maxLines = 1,
                onValueChange = {
                    if (it.length <= 1) number1 = it
                },
                modifier = Modifier.width(50.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = White,
                    backgroundColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    focusedIndicatorColor = Transparent
                )
            )
        }

    }

}

@Composable
fun OtpCell(
    modifier: Modifier,
    value: String,
    isCursorVisible: Boolean = false
) {
    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }

    Box(
        modifier = modifier
            .background(TextColorSilverHint, shape = RoundedCornerShape(10.dp)),
    ) {
        Text(
            text = if (isCursorVisible) cursorSymbol else value,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun PinInput(
    modifier: Modifier = Modifier,
    length: Int = 5,
    value: String = "",
    onValueChanged: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    TextField(
        value = value,
        onValueChange = {
            if (it.length <= length) {
                if (it.all { c -> c in '0'..'9' }) {
                    onValueChanged(it)
                }
                if (it.length >= length) {
                    keyboard?.hide()
                }
            }
        },
        // Hide the text field
        modifier = Modifier
            .size(0.dp)
            .focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(length) {
            OtpCell(
                modifier = modifier
                    .size(width = 45.dp, height = 60.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(MaterialTheme.colors.surface)
                    .clickable {
                        focusRequester.requestFocus()
                        keyboard?.show()
                    },
                value = value.getOrNull(it)?.toString() ?: "",
                isCursorVisible = value.length == it
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun OtpChat() {
    var text by remember { mutableStateOf("1") }
    val maxChar = 1

    Column(
        Modifier.background(DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { if (it.length <= maxChar) text = it },
            modifier = Modifier.width(50.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = White,
                backgroundColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                focusedIndicatorColor = Transparent
            )
        )
        Divider(
            Modifier
                .width(28.dp)
                .padding(bottom = 2.dp)
                .offset(y = -10.dp),
            color = White,
            thickness = 1.dp
        )
    }
}

