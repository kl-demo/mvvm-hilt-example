package kldemo.mvvmhiltexample.domain.langs

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage

interface ProgrammingLanguagesManager {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
}