package com.bn.saudimarche.presentation.screens.main


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.Typography


@Preview(showBackground = true)
@Composable
fun MainScreen(
    navController: NavController? = null,
) {
    Text(
        text = stringResource(id = R.string.app_name),
        style = Typography.h4
    )

}



