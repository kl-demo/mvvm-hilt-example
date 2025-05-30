package kldemo.mvvmhiltexample.presentation.lang_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails
import kldemo.mvvmhiltexample.domain.lang_details.ProgrammingLanguageDetailsManager
import kldemo.mvvmhiltexample.presentation.navigator.AppNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProgrammingLanguageDetailsViewModel @Inject constructor(
    private val programmingLanguageDetailsManager: ProgrammingLanguageDetailsManager,
    private val appNavigator: AppNavigator
) :
    ViewModel() {

    private val programmingLanguageDetailsViewStateMutable: MutableLiveData<ProgrammingLanguageDetailsViewState> =
        MutableLiveData<ProgrammingLanguageDetailsViewState>()
    val programmingLanguageDetailsViewState: LiveData<ProgrammingLanguageDetailsViewState> =
        programmingLanguageDetailsViewStateMutable

    init {
        programmingLanguageDetailsViewStateMutable.value =
            getInitProgrammingLanguageDetailsViewState()
    }

    fun setLangName(name: String) {
        programmingLanguageDetailsViewStateMutable.value =
            getCurrentProgrammingLanguageDetailsViewState().copy(
                langName = name
            )
        getProgrammingLanguageDetails(name)
    }

    fun backClicked() {
        appNavigator.navigateBack()
    }

    private fun getProgrammingLanguageDetails(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val programmingLanguageDetails =
                programmingLanguageDetailsManager.getProgrammingLanguageDetails(name)
            withContext(Dispatchers.Main) {
                programmingLanguageDetailsViewStateMutable.value =
                    getCurrentProgrammingLanguageDetailsViewState().copy(
                        programmingLanguageDetails = programmingLanguageDetails,
                        isLoading = false
                    )
            }
        }
    }

    private fun getCurrentProgrammingLanguageDetailsViewState() =
        programmingLanguageDetailsViewStateMutable.value
            ?: getInitProgrammingLanguageDetailsViewState()

    private fun getInitProgrammingLanguageDetailsViewState() = ProgrammingLanguageDetailsViewState(
        langName = "",
        programmingLanguageDetails = ProgrammingLanguageDetails("", ""),
        isLoading = true
    )
}