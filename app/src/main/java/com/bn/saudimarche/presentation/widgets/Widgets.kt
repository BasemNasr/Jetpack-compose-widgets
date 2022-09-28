package com.bn.saudimarche.presentation.widgets

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.bn.saudimarche.R
import com.bn.saudimarche.presentation.theme.*
import java.net.*

@Composable
fun WidgetAppBar(
    title: String = stringResource(id = R.string.app_name),
    isMain: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddAction: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = title,
                style = Typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = TextColorSemiBlack
            )
        },
        actions = {
            if (isMain) {
                IconButton(
                    onClick = {
                        onButtonClicked()
                    },
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "About App")
                }
            } else {
                IconButton(
                    onClick = {
                        onButtonClicked()
                    },
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        },
        backgroundColor = ToolBarColor,
        elevation = elevation
    )
}

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String = "Click Me",
    textColor: Color = Color.White,
    elevation: Dp = 6.dp,
    background: Color = Color.Black,
    shape: Shape? = null,
    onButtonClicked: () -> Unit = {}
) {
    Button(
        onClick = { onButtonClicked.invoke() },
        modifier = modifier,
        elevation = ButtonDefaults.elevation(elevation),
        shape = shape ?: RoundedCornerShape(80.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontFamily = somarSemiBold,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
            )
        )
    }
}

@Composable
fun AppTextField(
    modifier: Modifier,
    value: String,
    hintLabel: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onValueChanged: (text: String) -> Unit = {}
) {
    var enteredText by remember { mutableStateOf("") }
    TextField(
        value = enteredText,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        onValueChange = {
            enteredText = it
            onValueChanged.invoke(it)
        },
        label = { Text(hintLabel) },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        textStyle = TextStyle(
            color = textColorBrown,
            fontWeight = FontWeight.Bold,
            fontFamily = somarRegular,
            fontSize = 16.sp
        ),
        modifier = modifier
    )
}

@Composable
fun CircleCheckbox(selected: Boolean, enabled: Boolean = true, onChecked: () -> Unit) {

    val imageVector = if (selected) Icons.Filled.CheckCircle else Icons.Outlined.Circle
    val tint =
        if (selected) textColorBrown.copy(alpha = 0.8f) else textColorBrown.copy(alpha = 0.8f)
    val background = if (selected) Color.White else Color.Transparent

    IconButton(
        onClick = { onChecked() },
        modifier = Modifier.offset(x = 4.dp, y = 4.dp),
        enabled = enabled
    ) {

        Icon(
            imageVector = imageVector, tint = tint,
            modifier = Modifier.background(background, shape = CircleShape),
            contentDescription = "checkbox"
        )
    }
}


@Composable
fun TextWithBox(
    text: String = "Prayer",
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0x59FFFFFF), shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = text,
            style = Typography.h2,
        )
    }
}

@Composable
fun handleAllKindOfExceptions(
    context: Context,
    throwError: Throwable?,
    error: Throwable?,
    response: String?,
    code: Int?
) {
    when {
        response != null -> Log.e("ErrorNetwork", "handleAllKindOfExceptions $code $response")
        throwError != null -> handleException(context, throwError)
        error != null -> handleException(context, error)
    }
}

@Composable
fun handleException(
    context: Context,
    t: Throwable
) {
    when (t) {
        is SocketTimeoutException -> ShowErrorToast(
            context,
            stringResource(id = R.string.time_out_error)
        )
        is UnknownHostException -> ShowErrorToast(
            context,
            stringResource(id = R.string.connection_error)
        )
        is ConnectException -> ShowErrorToast(
            context,
            stringResource(id = R.string.connection_error)
        )
        is NoRouteToHostException -> ShowErrorToast(
            context,
            stringResource(id = R.string.connection_error)
        )
        is PortUnreachableException -> ShowErrorToast(
            context,
            stringResource(id = R.string.connection_error)
        )
        is UnknownServiceException -> ShowErrorToast(
            context,
            stringResource(id = R.string.connection_error)
        )
        is BindException -> ShowErrorToast(context, stringResource(id = R.string.connection_error))
        else -> ShowErrorToast(context, t.message.toString())
    }
}

@Composable
fun ShowErrorToast(context: Context, message: String) {
    Toast.makeText(
        context, message,
        Toast.LENGTH_SHORT
    ).show()

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visibleState = MutableTransitionState(true),
        enter = slideInHorizontally(
            initialOffsetX = { -100 },
            animationSpec = tween(durationMillis = 1500)
        ) + expandHorizontally(
            expandFrom = Alignment.CenterHorizontally
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { 100 },
            animationSpec = tween(durationMillis = 1500)
        ) + shrinkVertically(
            clip = true,
            shrinkTowards = Alignment.Bottom,
            animationSpec = tween(500)
        ),
    ) {
        content()
    }
}

@Composable
fun ShowReminderDropDownMenu(
    showDialog: MutableState<Boolean>,
    items: List<String>,
    navController: NavController, onDismiss: (Boolean) -> Unit,
    onItemSelected: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .absolutePadding()
    ) {
        DropdownMenu(
            expanded = expanded,
            properties = PopupProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                focusable = true, excludeFromSystemGesture = true
            ),
            onDismissRequest = {
                expanded = false
                onDismiss(showDialog.value)
            },
            modifier = Modifier
                .width(200.dp)
                .background(Color.White)
        ) {
            items.forEachIndexed { index, text ->
                DropdownMenuItem(onClick = {
                    onDismiss.invoke(showDialog.value)
                    onItemSelected.invoke(index)
                }) {
                    Icon(
                        modifier = Modifier
                            .width(25.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                    Text(
                        text = text,
                        modifier = Modifier.clickable {
                            expanded = false
                            onDismiss.invoke(showDialog.value)
                            onItemSelected.invoke(index)
                        }, fontWeight = FontWeight.W300
                    )
                }
            }
        }
    }
}

@Composable
fun CircularImage(
    modifier: Modifier = Modifier,
    imageResourceId: Int
) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
//        border = BorderStroke(0.5.dp, androidx.compose.ui.graphics.Color.LightGray),
//        elevation = 4.dp,
//        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun ImageWithBackground(
        painter: Painter,
        @DrawableRes backgroundDrawableResId: Int,
        contentDescription: String?,
        modifier: Modifier = Modifier,
        alignment: Alignment = Alignment.Center,
        contentScale: ContentScale = ContentScale.Fit,
        alpha: Float = DefaultAlpha,
        colorFilter: ColorFilter? = null
    ) {
        Box(
            modifier = modifier
        ) {
            Image(
                painter = painterResource(backgroundDrawableResId),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
            )
            Image(
                painter = painter,
                contentDescription = contentDescription,
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter,
                modifier = Modifier
                    .matchParentSize()
            )
        }
    }


}