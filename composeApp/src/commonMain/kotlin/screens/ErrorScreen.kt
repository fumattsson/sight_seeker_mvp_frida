package screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.ErrorScreenComponent

@Composable
fun ErrorScreen(component: ErrorScreenComponent) {
    Button(onClick = {
        component.goBack()
    }) {
        Text("Go back")
    }
}