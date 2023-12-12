package navigation

sealed interface SplashScreenEvent {
    data object NavigateToMainScreen: SplashScreenEvent
}