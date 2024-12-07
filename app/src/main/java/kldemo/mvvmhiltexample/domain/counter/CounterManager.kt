package kldemo.mvvmhiltexample.domain.counter

interface CounterManager {
    fun getNumberOfClicks(): Int
    fun incrementNumberOfClicks()
}