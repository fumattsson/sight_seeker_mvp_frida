package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class AttractionDetailsScreenComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit,
    name: String,
    description: String,
): ComponentContext by componentContext {

    private val _name = MutableValue(name)
    val attractionName: Value<String> = _name

    private val _description = MutableValue(description)
    val attractionDescription: Value<String> = _description

    fun goBack() {
        onGoBack()
    }
}