package kldemo.mvvmhiltexample.data.lang_details

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails

interface ProgrammingLanguageDetailsDataSource {
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}