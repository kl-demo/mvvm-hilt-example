package kldemo.mvvmhiltexample.data.langs

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage

interface ProgrammingLanguagesDataSource {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
}