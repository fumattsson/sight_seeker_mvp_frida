package navigation

import com.arkivanov.decompose.ComponentContext

class SplashScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToErrorScreen: () -> Unit,
    private val onNavigateToMainScreen: () -> Unit
): ComponentContext by componentContext {
fun onEvent(event: SplashScreenEvent) {
    when(event) {
        SplashScreenEvent.NavigateToErrorScreen -> onNavigateToErrorScreen()
        is SplashScreenEvent.NavigateToMainScreen -> onNavigateToMainScreen()
    }
}
}