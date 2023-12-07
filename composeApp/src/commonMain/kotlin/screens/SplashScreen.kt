package com.example.sightseekerdemo.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import navigation.SplashScreenComponent
import navigation.SplashScreenEvent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.ui.draw.alpha

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen(component: SplashScreenComponent) {

<<<<<<< HEAD
    // Display splash screen for 5000ms, then launch event to display main screen
    var showSplashScreen by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        showSplashScreen = false
=======
    val alpha = remember {
        Animatable(0f)
>>>>>>> 5d090a7 (remove unnecessary boolean logic in launchedEffect and add animations to SplashScreen)
    }

    // Display splash screen for 3000ms, then launch event to display main screen
    LaunchedEffect(key1 = Unit) {
        alpha.animateTo(
            1f,
            animationSpec = tween(2500)
        )
        delay(1000)
        component.onEvent(SplashScreenEvent.NavigateToMainScreen)
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "SightSeeker",
            modifier = Modifier.padding(bottom = 200.dp).alpha(alpha.value),
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
    // TODO: REMOVE, TEMPORARY BUTTON FOR DEVELOPMENT
    Button(onClick = {
        component.onEvent(SplashScreenEvent.NavigateToErrorScreen)
    }) {
        Text("Go to Error Screen")
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
    }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource("splash.png"),
            contentDescription = "Travel image",
            modifier = Modifier.fillMaxWidth().alpha(alpha.value),
            contentScale = ContentScale.FillWidth
        )
    }
}