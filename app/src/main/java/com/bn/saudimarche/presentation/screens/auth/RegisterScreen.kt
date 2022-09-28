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
import com.bn.saudimarche.presentation.theme.BOLD_SILVER_BACKGROUND_COLOR
import com.bn.saudimarche.presentation.theme.TextColorSilverHint
import com.bn.saudimarche.presentation.theme.Typography
import com.bn.saudimarche.presentation.theme.textColorBrown
import com.bn.saudimarche.presentation.widgets.AppButton
import com.bn.saudimarche.presentation.widgets.AppTextField
import com.bn.saudimarche.presentation.widgets.CircleCheckbox


@Preview()
@Composable
fun RegisterScreen(navController: NavController? = null) {

    var username by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rePassword by remember { mutableStateOf("") }

    val termsAndServiceCheckState = remember { mutableStateOf(false) }



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

            BoxRegisterDataInputs(username, emailAddress, phoneNumber, password, rePassword)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                CircleCheckbox(termsAndServiceCheckState.value) {
                    termsAndServiceCheckState.value = !termsAndServiceCheckState.value
                }
                Text(
                    text = stringResource(id = R.string.confirm_terms_and_services),
                    modifier = Modifier
                        .padding(start = 10.dp, top = 6.dp)
                        .clickable {
                            //open terms page
                        },
                    style = Typography.body1,
                    color = TextColorSilverHint
                )
            }


            Spacer(modifier = Modifier.height(20.dp))
            AppButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(340.dp)
                    .padding(start = 20.dp, end = 20.dp),
                text = stringResource(id = R.string.create_account),
                background = textColorBrown,
                textColor = Color.White,
                elevation = 0.dp
            ) {
                //call register api here
                navController?.navigate(AppScreens.OtpScreen.name)
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
                    text = stringResource(id = R.string.have_account_already),
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp, top = 2.dp),
                    style = Typography.body1,
                    color = TextColorSilverHint,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(id = R.string.login),
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)
                        .clickable {
                            navController?.navigate(AppScreens.LoginScreen.name)
                        },
                    style = Typography.h5,
                    color = textColorBrown,
                    textAlign = TextAlign.Center,

                    )


            }


        }


    }
}

@Composable
private fun BoxRegisterDataInputs(
    username: String,
    emailAddress: String,
    phoneNumber: String,
    password: String,
    rePassword: String
) {
    var username1 = username
    var emailAddress1 = emailAddress
    var phoneNumber1 = phoneNumber
    var password1 = password
    var rePassword1 = rePassword
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
            text = stringResource(id = R.string.welcome),
            modifier = Modifier.padding(10.dp),
            style = Typography.h5,
            color = textColorBrown
        )
        Text(
            text = stringResource(id = R.string.register_hint),
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
            value = username1,
            hintLabel = stringResource(id = R.string.user_name),
        ) {
            username1 = it
        }

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailAddress1,
            hintLabel = stringResource(id = R.string.email_address),
        ) {
            emailAddress1 = it
        }

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            value = phoneNumber1,
            hintLabel = stringResource(id = R.string.phone_number),
        ) {
            phoneNumber1 = it
        }

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password1,
            hintLabel = stringResource(id = R.string.password),
        ) {
            password1 = it
        }

        AppTextField(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 50.dp)
                .height(49.dp)
                .fillMaxWidth()
                .background(Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            value = rePassword1,
            hintLabel = stringResource(id = R.string.confirm_password),
        ) {
            rePassword1 = it
        }
    }
}

