package navigation

sealed interface SplashScreenEvent {
    data object NavigateToErrorScreen: SplashScreenEvent
    data object NavigateToMainScreen: SplashScreenEvent
}