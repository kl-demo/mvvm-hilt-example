package kldemo.mvvmhiltexample.presentation.langs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kldemo.mvvmhiltexample.domain.langs.ProgrammingLanguagesManager
import kldemo.mvvmhiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmhiltexample.presentation.navigator.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProgrammingLanguagesViewModel @Inject constructor(
    private val programmingLanguagesManager: ProgrammingLanguagesManager,
    private val appNavigator: AppNavigator
) :
    ViewModel() {

    private val programmingLanguagesViewStateMutable: MutableLiveData<ProgrammingLanguagesViewState> =
        MutableLiveData<ProgrammingLanguagesViewState>()
    val programmingLanguagesViewState: LiveData<ProgrammingLanguagesViewState> =
        programmingLanguagesViewStateMutable

    init {
        programmingLanguagesViewStateMutable.value = getInitProgrammingLanguagesViewState()
        getProgrammingLanguages()
    }

    fun detailsClicked(name: String) {
        appNavigator.navigateTo(Screen.ProgrammingLanguageDetails(name))
    }

    private fun getProgrammingLanguages() {
        viewModelScope.launch(Dispatchers.IO) {
            val programmingLanguages = programmingLanguagesManager.getProgrammingLanguages()
            withContext(Dispatchers.Main) {
                programmingLanguagesViewStateMutable.value =
                    getCurrentProgrammingLanguagesViewState().copy(
                        programmingLanguages = programmingLanguages,
                        isLoading = false
                    )
            }
        }
    }

    private fun getCurrentProgrammingLanguagesViewState() =
        programmingLanguagesViewStateMutable.value ?: getInitProgrammingLanguagesViewState()

    private fun getInitProgrammingLanguagesViewState() = ProgrammingLanguagesViewState(
        programmingLanguages = emptyList(),
        isLoading = true
    )
}