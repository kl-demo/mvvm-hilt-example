package kldemo.mvvmhiltexample.domain.lang_details

import kldemo.mvvmhiltexample.data.core.model.ProgrammingLanguageDetails
import kldemo.mvvmhiltexample.data.lang_details.ProgrammingLanguageDetailsDataSource
import javax.inject.Inject

class ProgrammingLanguageDetailsManagerImpl @Inject constructor(private val programmingLanguageDetailsDataSource: ProgrammingLanguageDetailsDataSource) :
    ProgrammingLanguageDetailsManager {

    override suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails =
        programmingLanguageDetailsDataSource.getProgrammingLanguageDetails(name)

}