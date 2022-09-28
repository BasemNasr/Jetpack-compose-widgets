package com.bn.saudimarche.presentation.screens.intro

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.navigation.AppScreens
import com.bn.saudimarche.presentation.theme.*
import com.bn.saudimarche.presentation.widgets.AppButton


@Preview("Hello")
@Composable
fun IntroScreen(navController: NavController? = null) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .wrapContentHeight()
            .background(Color.Red)
    ) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .background(BACKGROUND_COLOR),
            onDraw = {
                withTransform({
                    translate(top = -1000f)
                    rotate(degrees = -45F)
                    scale(40f, 40f)
                }) {
                    drawCircle(
                        color = CIRCLE_COLOR,
                        radius = 20f
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.add_cart),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.splash_icon),
                modifier = Modifier
                    .width(148.dp)
                    .height(86.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.welcome),
                modifier = Modifier.padding(10.dp),
                style = Typography.h5,
                color = textColorBrown
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.intro_register_hint),
                modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                style = Typography.body1,
                color = TextColorSilverHint,
                textAlign = TextAlign.Center
            )
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
                navController?.navigate(AppScreens.RegisterScreen.name)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(6.dp),
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

