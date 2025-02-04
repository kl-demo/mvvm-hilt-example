package kldemo.mvvmhiltexample.domain.langs

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmhiltexample.data.langs.ProgrammingLanguagesDataSource
import javax.inject.Inject

class ProgrammingLanguagesManagerImpl @Inject constructor(private val programmingLanguagesDataSource: ProgrammingLanguagesDataSource) :
    ProgrammingLanguagesManager {

    override suspend fun getProgrammingLanguages(): List<ProgrammingLanguage> =
        programmingLanguagesDataSource.getProgrammingLanguages()
}