package navigation

sealed interface MainScreenEvent {
    data object NavigateToErrorScreen: MainScreenEvent
}