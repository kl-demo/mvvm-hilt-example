package kldemo.mvvmhiltexample.domain.counter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kldemo.mvvmhiltexample.data.counter.CounterDataSource

@Module
@InstallIn(ViewModelComponent::class)
object CounterManagerModule {

    @Provides
    @ViewModelScoped
    fun provideCounterManager(counterDataSource: CounterDataSource): CounterManager = CounterManagerImpl(counterDataSource)
}