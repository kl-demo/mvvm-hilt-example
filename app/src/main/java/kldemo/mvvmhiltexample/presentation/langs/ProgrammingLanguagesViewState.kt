package kldemo.mvvmhiltexample.presentation.langs

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage

data class ProgrammingLanguagesViewState(
    val programmingLanguages: List<ProgrammingLanguage>,
    val isLoading: Boolean
)
