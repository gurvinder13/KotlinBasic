package com.example.kotlinbasicexp.flow

/**
 * The flowOn operator in Kotlin Flow is used to change the context in which the upstream
 * operations of the Flow are executed. It allows you to specify a coroutine dispatcher so
 * that the emissions and intermediate operations (such as transformations and filters) within
 * the Flow are executed in a different coroutine context.
 *
 * In simpler terms, flowOn lets you switch the "thread" or "dispatcher" on which the
 * Flow's operations are performed. This can be useful when you want to perform certain operations,
 * like network requests or disk I/O, in a different context than the one in which the
 * Flow was collected, ensuring that those operations are executed efficiently without blocking
 * the main thread or UI thread.
 */
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val flow = flow {
            for (i in 1..3) {
                delay(100) // Simulate some asynchronous operation
                println("Emitting value $i in ${Thread.currentThread().name}")
                emit(i)
            }
        }.flowOn(Dispatchers.IO) // Switch the upstream operations to IO dispatcher
       // flow.flowOn(Dispatchers.IO)  both are same
        flow.collect { value ->
            println("Collecting value $value in ${Thread.currentThread().name}")
        }
    }

    println("Total time: $time ms")
}
