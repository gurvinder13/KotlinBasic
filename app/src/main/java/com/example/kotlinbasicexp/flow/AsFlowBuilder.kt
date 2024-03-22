package com.example.kotlinbasicexp.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val f = (1..3).asFlow()
    println("1. Start to collect")
    f.collect{
        println("Collected $it")
    }
    println("2. Start to collect")
    f.collect{
        println("Collected $it")
    }
    getData()
    getDataList()

}

suspend fun getData() {
    val list = listOf(1, 2, 3)
    val flow = list.asFlow().onEach {
        println("Emitting $it")
    }
    flow.collect {
        println("Received $it")
    }
}

suspend fun getDataList() {
    val list = listOf(1, 2, 3).asFlow()
    list.onEach {
        println("Emitting $it")
    }.collect {
        println("Received $it")
    }
}
