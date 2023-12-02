package navigation

sealed interface SplashScreenEvent {
    data object ClickButtonError: SplashScreenEvent
    data object ClickButtonMain: SplashScreenEvent
}