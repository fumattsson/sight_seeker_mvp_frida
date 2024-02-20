package navigation

sealed interface MainScreenEvent {
    data object NavigateToErrorScreen: MainScreenEvent
    data object NavigateToAttractionDetailsScreen: MainScreenEvent
}