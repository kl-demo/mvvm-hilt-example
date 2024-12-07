package kldemo.mvvmhiltexample.domain.counter

import kldemo.mvvmhiltexample.data.counter.CounterDataSource
import javax.inject.Inject

class CounterManagerImpl @Inject constructor(private val counterDataSource: CounterDataSource)  : CounterManager {
    override fun getNumberOfClicks(): Int = counterDataSource.getNumberOfClicks()

    override fun incrementNumberOfClicks() {
        counterDataSource.setNumberOfClicks(counterDataSource.getNumberOfClicks()+1)
    }
}