package com.example.kotlinbasicexp.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

// Kotlin Flows basic example (Emit & Collect Function)
suspend fun main() {
    /**
     * flowOf :- create a Flow from a fixed set of values
     */
    val firstFlow = flowOf(1).collect {
        println("firstFlow ".plus(it.toString()))
    }
    val secondFlow: Unit = flowOf<Int>(1, 2, 3, 2).collect {
        println("secondFlow $it")
    }
    val data = producer()
    data.collect {
        println(it)
    }

    /**
     * The asFlow() function in Kotlin Flow is used to convert collections, sequences,
     * or other iterables into a Flow. It allows you to easily create a Flow from existing synchronous data sources.
     */

    listOf("A", "B", "C").asFlow().collect {
        println("asFlow $it")
    }
}

// producer fun
private fun producer(): Flow<Int> = flow {
    val list = listOf(1, 3, 5, 2)
    list.forEach {
        delay(1000)
        emit(it)
    }
}

