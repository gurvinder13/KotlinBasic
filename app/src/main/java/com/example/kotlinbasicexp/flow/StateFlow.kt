package com.example.kotlinbasicexp.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A StateFlow is a hot flow that represents a state, holding a single value at a time.
 * It is also a conflated flow, meaning that when a new value is emitted, the most recent value is
 * retained and immediately emitted to new collectors.
 * It is useful when you need to maintain a single source of truth for a state and automatically
 * update all the collectors with the latest state.
 * It always has an initial value and only stores the latest emitted value.
 */

fun main() = runBlocking<Unit> {
    val mutableStateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = mutableStateFlow

// Collect values from stateFlow
  val job1 =  launch {
        stateFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

// Collect values from stateFlow
    val job2 =  launch {
        stateFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }


// Update the state
    launch {
        repeat(2) { i ->
            mutableStateFlow.value = i
            delay(100) // Introduce a delay to see intermediate states
        }
    }
    delay(2000)
    job1.cancel()
    job2.cancel()
}