package kldemo.mvvmhiltexample.domain.lang_details

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails

interface ProgrammingLanguageDetailsManager {
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}