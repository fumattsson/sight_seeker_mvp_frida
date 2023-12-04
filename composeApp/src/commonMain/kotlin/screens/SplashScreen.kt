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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen(component: SplashScreenComponent) {

    // Display splash screen for 5000ms, then launch event to display main screen
    var showSplashScreen by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        showSplashScreen = false
    }
    if (!showSplashScreen) {
        component.onEvent(SplashScreenEvent.NavigateToMainScreen)
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "SightSeeker",
            modifier = Modifier.padding(bottom = 200.dp),
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
    // TODO: REMOVE TEMPORARY BUTTON FOR DEVELOPMENT
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
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}