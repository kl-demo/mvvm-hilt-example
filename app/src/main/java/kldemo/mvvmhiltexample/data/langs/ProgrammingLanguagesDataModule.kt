package kldemo.mvvmhiltexample.data.langs

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kldemo.mvvmhiltexample.data.core.Api

@Module
@InstallIn(SingletonComponent::class)
object ProgrammingLanguagesDataModule {

    @Provides
    fun provideProgrammingLanguageDataSource(api: Api): ProgrammingLanguagesDataSource =
        ProgrammingLanguagesDataSourceImpl(api)
}