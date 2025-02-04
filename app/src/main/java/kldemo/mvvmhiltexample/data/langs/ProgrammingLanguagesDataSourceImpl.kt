package kldemo.mvvmhiltexample.data.langs

import kldemo.mvvmhiltexample.data.core.Api
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguage
import javax.inject.Inject

class ProgrammingLanguagesDataSourceImpl @Inject constructor(private val api: Api) :
    ProgrammingLanguagesDataSource {

    override suspend fun getProgrammingLanguages(): List<ProgrammingLanguage> =
        api.getProgrammingLanguages()
}