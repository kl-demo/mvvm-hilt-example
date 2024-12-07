package kldemo.mvvmhiltexample.presentation.navigator

import androidx.fragment.app.FragmentManager

sealed class Screen {
    data object Counter : Screen()
}

interface AppNavigator {
    fun setFragmentManager(fragmentManager: FragmentManager)
    fun release()
    fun navigateTo(screen: Screen)
    fun navigateBack()
}