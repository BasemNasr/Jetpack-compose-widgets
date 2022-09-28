package com.bn.saudimarche.presentation.screens.auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.navigation.AppScreens
import com.bn.saudimarche.presentation.theme.*
import com.bn.saudimarche.presentation.widgets.AppButton
import com.bn.saudimarche.presentation.widgets.AppTextField


@Preview()
@Composable
fun LoginScreen(navController: NavController? = null) {

    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

            BoxLoginDataInputs(phoneNumber, password)

            Spacer(modifier = Modifier.height(40.dp))
            AppButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(340.dp)
                    .padding(start = 20.dp, end = 20.dp),
                text = stringResource(id = R.string.login),
                background = textColorBrown,
                textColor = Color.White,
                elevation = 0.dp
            ) {
                //call register api here
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 6.dp, bottom = 40.dp, end = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.have_not_account),
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp, top = 2.dp),
                    style = Typography.body1,
                    color = TextColorSilverHint,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(id = R.string.regiser_new_account),
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .clickable {
                            navController?.navigate(AppScreens.RegisterScreen.name)
                        },
                    style = Typography.h5,
                    color = textColorBrown,
                    textAlign = TextAlign.Center,

                    )


            }


        }
    }
}

@Preview("BoxLoginDataInputs")
@Composable
private fun BoxLoginDataInputs(
    phoneNumber: String?=null,
    password: String?=null,
) {
    var phoneNumber = phoneNumber
    var password = password
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 10.dp, end = 10.dp)
            .wrapContentHeight()
            .background(Color.White, shape = RoundedCornerShape(50.dp)),
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

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            value = phoneNumber?:"",
            hintLabel = stringResource(id = R.string.phone_number),
        ) {
            phoneNumber = it
        }

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password?:"",
            hintLabel = stringResource(id = R.string.password),
        ) {
            password = it
        }

        Text(
            text = stringResource(id = R.string.forget_password),
            modifier = Modifier.padding(top = 10.dp, bottom = 50.dp),
            style = Typography.body1,
            color = RED_COLOR
        )
    }
}

