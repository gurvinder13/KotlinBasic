package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking

fun main() {
    val flow: Flow<Int> = flow {
        delay(100)
        println("Emitting the first value")
        emit(1)

        delay(100)
        println("Emitting the second value")
        emit(2)
    }
    runBlocking {
        val item = flow.last()
        println("Received value $item")

    }
}