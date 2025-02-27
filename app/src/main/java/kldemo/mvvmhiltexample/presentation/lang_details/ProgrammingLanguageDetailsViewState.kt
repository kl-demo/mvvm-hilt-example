package kldemo.mvvmhiltexample.presentation.lang_details

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails

data class ProgrammingLanguageDetailsViewState(
    val langName: String,
    val programmingLanguageDetails: ProgrammingLanguageDetails,
    val isLoading: Boolean
)
