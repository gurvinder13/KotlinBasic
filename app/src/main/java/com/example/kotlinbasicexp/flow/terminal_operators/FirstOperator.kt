package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
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
        val item = flow.first()
        val item1 = flow.first { it > 1 }
        println("Received value $item")
        println("Received value $item1")

    }
}