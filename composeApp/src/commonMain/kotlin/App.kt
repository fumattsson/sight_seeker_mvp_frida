import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.example.sightseekerdemo.android.SplashScreen
import navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screens.ErrorScreen
import screens.MainScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(root: RootComponent) {
        MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.SplashScreen -> SplashScreen(instance.component)
                is RootComponent.Child.MainScreen -> MainScreen(instance.component)
                is RootComponent.Child.ErrorScreen -> ErrorScreen(instance.component)
            }
        }
    }
}