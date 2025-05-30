package kldemo.mvvmhiltexample.presentation.navigator

import androidx.fragment.app.FragmentManager
import kldemo.mvvmhiltexample.R
import kldemo.mvvmhiltexample.presentation.lang_details.ProgrammingLanguageDetailsFragment
import kldemo.mvvmhiltexample.presentation.langs.ProgrammingLanguagesFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    private var fragmentManager: FragmentManager? = null

    override fun setFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun navigateTo(screen: Screen) {
        val fragment = when (screen) {
            is Screen.ProgrammingLanguages -> ProgrammingLanguagesFragment.newInstance()
            is Screen.ProgrammingLanguageDetails -> ProgrammingLanguageDetailsFragment.newInstance(
                screen.name
            )
        }

        fragmentManager?.run {
            beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(fragment::class.java.canonicalName)
                .commit()
        }
    }

    override fun navigateBack() {
        fragmentManager?.run {
            return popBackStack()
        }
    }
}