package kldemo.mvvmhiltexample.data.lang_details

import kldemo.mvvmhiltexample.data.core.Api
import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails
import javax.inject.Inject

class ProgrammingLanguageDetailsDataSourceImpl @Inject constructor(private val api: Api) :
    ProgrammingLanguageDetailsDataSource {

    override suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails =
        api.getProgrammingLanguageDetails(name)
}