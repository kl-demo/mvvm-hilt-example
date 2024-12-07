package kldemo.mvvmhiltexample.presentation.counter

data class CounterViewState(
    val numberOfClicks: Int,
    val isLoading: Boolean
)
