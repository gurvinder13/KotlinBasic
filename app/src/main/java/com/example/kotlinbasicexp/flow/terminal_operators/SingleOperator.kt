package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking

fun main() {
    /**
     * single operator is used to ensure that a Flow emits only a single value.
     * If the Flow emits more than one value or no values, it throws an exception.
     * This operator is useful when you expect the Flow to emit exactly one value and want to handle the case where it emits more or none.
     */
    val flow: Flow<Int> = flow {
        delay(100)
        println("Emitting the first value")
        emit(1)

        delay(100)
        println("Emitting the second value")
       // emit(2)
    }
    // Exception in thread "main" java.lang.IllegalArgumentException: Flow has more than one element
    runBlocking {
        val item = flow.single()
        println("Received value $item")

    }
}