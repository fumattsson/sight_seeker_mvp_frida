package navigation

import com.arkivanov.decompose.ComponentContext

class MainScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToErrorScreen: () -> Unit,
    private val onNavigateToAttractionDetailsScreen: () -> Unit
    ): ComponentContext by componentContext {
    fun onEvent(event: MainScreenEvent) {
        when (event) {
            MainScreenEvent.NavigateToErrorScreen -> onNavigateToErrorScreen()
            MainScreenEvent.NavigateToAttractionDetailsScreen -> onNavigateToAttractionDetailsScreen()
        }
    }
}