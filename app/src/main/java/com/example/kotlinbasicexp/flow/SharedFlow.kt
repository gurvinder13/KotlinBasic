package com.example.kotlinbasicexp.flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * SharedFlow is a mutable data holder that can emit multiple values.
 * SharedFlow supports the tryEmit function which allows for safe emitting of values and
 *    propagating errors to downstream collectors
 * SharedFlow is designed for broadcasting values to multiple collectors
 * SharedFlow is often used for situations where multiple parts of an application need to observe
 *     the same data source, such as in a messaging app where multiple users need to observe the same chat room
 * SharedFlow does not have an initial value, and you can configure its replay cache to store a certain number of previously emitted values for new collectors.
 */
/*
fun main() = runBlocking {

   */
/* val sharedFlow = MutableSharedFlow<Int>()
    val job1 = launch {
        sharedFlow.collect {
            println("Job 1 received: $it")
        }
    }
    val job2 = launch {
        sharedFlow.collect {
            println("Job 2 received: $it")
        }
    }
    delay(1000)
    sharedFlow.emit(1)
    sharedFlow.emit(2)
    job1.cancel()
    delay(2000)
    sharedFlow.emit(3)
    job2.cancel()*//*





}
*/
fun main(){
    GlobalScope.launch {
        val data = producer()
        data.collect{
            println("First collector $it")
        }
        val data1 = producer()
        data1.collect{
            println("Second collector $it")
        }
    }
}

private fun producer():Flow<Int> {
    var mutableSharedFlow = MutableSharedFlow<Int>()
    val list = listOf<Int>(1, 2, 3, 4, 5)
    GlobalScope.launch {
        list.forEach {
            mutableSharedFlow.emit(it)
            delay(100)
        }
    }
    return mutableSharedFlow
}
