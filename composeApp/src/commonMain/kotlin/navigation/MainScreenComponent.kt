package navigation

import com.arkivanov.decompose.ComponentContext

class MainScreenComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    fun goBack() {
        onGoBack()
    }
}