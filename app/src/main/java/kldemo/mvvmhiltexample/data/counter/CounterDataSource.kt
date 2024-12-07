package kldemo.mvvmhiltexample.data.counter

interface CounterDataSource {
    fun getNumberOfClicks(): Int
    fun setNumberOfClicks(numberOfClicks: Int)
}