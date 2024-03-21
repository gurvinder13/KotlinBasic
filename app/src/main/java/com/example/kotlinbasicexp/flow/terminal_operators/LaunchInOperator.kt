package com.example.kotlinbasicexp.flow.terminal_operators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    /**
     *launchIn operator is used to launch a coroutine that collects elements emitted by the Flow.
     * It allows you to asynchronously collect and process elements emitted by the Flow without blocking the current thread
     */
    val flow: Flow<Int> = flow {
        delay(100)
        println("Emitting first value")
        emit(1)

        delay(100)
        println("Emitting second value")
        emit(2)
    }

    val scope = CoroutineScope(EmptyCoroutineContext)
    flow.onEach { println("Received $it with launchIn()") }.launchIn(scope)

    scope.launch {
        flow.collect {
            println("Received $it in collect")
        }
    }

    Thread.sleep(1000)

}
