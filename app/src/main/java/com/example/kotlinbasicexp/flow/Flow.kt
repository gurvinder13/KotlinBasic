package com.example.kotlinbasicexp.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main () = runBlocking{
    val f = getSequence()
    println("Start collect")
    f.collect{
        println("Collected $it")
    }

}

fun getSequence() :Flow<Int> = flow {
    for (i in 1..3){
        delay(100)
        println("Emit $i")
        emit(i)
    }
}