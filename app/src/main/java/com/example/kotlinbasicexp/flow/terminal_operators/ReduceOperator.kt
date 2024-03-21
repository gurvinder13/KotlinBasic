package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.runBlocking

fun main() {
    /**
     * operation: A function that takes two elements emitted by the Flow and returns a single result.
     */
    val flow: Flow<Int> = flow {
        delay(100)
        println("Emitting the first value")
        emit(1)

        delay(100)
        println("Emitting the second value")
        emit(2)
    }
    runBlocking {
        val item = flow.reduce{ accumulator, emittedValue ->
            accumulator + emittedValue
        }
        println("Received $item")

    }

}