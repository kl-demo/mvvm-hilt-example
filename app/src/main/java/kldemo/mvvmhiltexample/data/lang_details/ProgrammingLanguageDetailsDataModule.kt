package kldemo.mvvmhiltexample.data.lang_details

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kldemo.mvvmhiltexample.data.core.Api

@Module
@InstallIn(SingletonComponent::class)
object ProgrammingLanguageDetailsDataModule {

    @Provides
    fun provideProgrammingLanguageDetailsDataSource(api: Api): ProgrammingLanguageDetailsDataSource =
        ProgrammingLanguageDetailsDataSourceImpl(api)
}