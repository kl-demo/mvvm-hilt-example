package kldemo.mvvmhiltexample.presentation.navigator

import androidx.fragment.app.FragmentManager
import kldemo.mvvmhiltexample.R
import kldemo.mvvmhiltexample.presentation.counter.CounterFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    private var fragmentManager: FragmentManager? = null

    override fun setFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun release() {
        fragmentManager = null
    }

    override fun navigateTo(screen: Screen) {
        val fragment = when (screen) {
            Screen.Counter -> CounterFragment()
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