package kldemo.mvvmhiltexample.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kldemo.mvvmhiltexample.R
import kldemo.mvvmhiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmhiltexample.presentation.navigator.Screen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        appNavigator.setFragmentManager(supportFragmentManager)
        if (savedInstanceState == null) {
            appNavigator.navigateTo(Screen.ProgrammingLanguages)
        }
    }
}