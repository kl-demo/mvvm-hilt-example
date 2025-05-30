package kldemo.mvvmhiltexample.presentation.navigator

import androidx.fragment.app.FragmentManager

sealed class Screen {
    data object ProgrammingLanguages : Screen()

    data class ProgrammingLanguageDetails(val name: String) : Screen()
}

interface AppNavigator {
    fun setFragmentManager(fragmentManager: FragmentManager)
    fun navigateTo(screen: Screen)
    fun navigateBack()
}