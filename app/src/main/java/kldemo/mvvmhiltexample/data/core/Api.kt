package kldemo.mvvmhiltexample.data.core

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails

interface Api {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}