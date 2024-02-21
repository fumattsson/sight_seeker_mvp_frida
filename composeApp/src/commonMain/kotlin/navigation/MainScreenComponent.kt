package navigation

import com.arkivanov.decompose.ComponentContext

class MainScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToErrorScreen: () -> Unit,
    private val onNavigateToAttractionDetailsScreen: (name: String, description: String) -> Unit
    ): ComponentContext by componentContext {
    fun onEvent(event: MainScreenEvent) {
        when (event) {
            MainScreenEvent.NavigateToErrorScreen -> onNavigateToErrorScreen()
        }
    }
    fun onAttractionDetailArrowClicked(name: String, description: String) {
        onNavigateToAttractionDetailsScreen(name, description)
    }
}