package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.runBlocking

fun main() {
    val flow: Flow<Int> = flow {
        delay(100)
        println("Emitting the first value")
        emit(1)

        delay(100)
        println("Emitting the second value")
       emit(1)
        emit(2)
    }
    runBlocking {
        val item = flow.toSet()
        println("Received from Set $item")

    }
    runBlocking {
        val item = flow.toList()
        println("Received from List $item")

    }
}