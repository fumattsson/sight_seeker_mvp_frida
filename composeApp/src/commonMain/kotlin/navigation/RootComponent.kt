package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SplashScreen,
        handleBackButton = false,
        childFactory = ::createChild
    )
    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
       return when(config) {
           Configuration.SplashScreen -> Child.SplashScreen(
               SplashScreenComponent(
                   componentContext = context,
                   onNavigateToMainScreen = {
                       navigation.pushNew(Configuration.MainScreen)
                   }
               )
           )
           is Configuration.MainScreen -> Child.MainScreen(
               MainScreenComponent(
                   componentContext = context,
                   onNavigateToErrorScreen = {
                       navigation.pushNew(Configuration.ErrorScreen)
                   }
               )
           )
           is Configuration.ErrorScreen -> Child.ErrorScreen(
               ErrorScreenComponent(
                   componentContext = context,
                   onGoBack = {
                       navigation.pop()
                   }
               )
           )
       }
    }

    sealed class Child {
        data class SplashScreen(val component: SplashScreenComponent): Child()
        data class MainScreen(val component: MainScreenComponent): Child()
        data class ErrorScreen(val component: ErrorScreenComponent): Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object SplashScreen: Configuration()
        @Serializable
        data object MainScreen: Configuration()
        @Serializable
        data object ErrorScreen: Configuration()
    }
}