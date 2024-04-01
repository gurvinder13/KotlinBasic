package com.example.kotlinbasicexp.higherOrderFn

/**
 *Higher-order function is a function that takes functions as parameters or returns a function
 * In Kotlin, ::add is a reference to the add function. It's called a function reference,
 * and it allows you to refer to a function without actually calling it.
 */

fun main() {
    val add = calculation(3, 4) { a, b -> a + b }
    val add1 = calculation(6, 4, ::addNum)
    println("Sum $add")
    println("Sum $add1")
    // Example 1: forEach
    val list = listOf(2,4,6,8)
    list.forEach {
        println(it)
    }
    // Example 2: filter
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers) // Output: [2, 4]
    // Example 3: map
    val number = listOf(1, 2, 3, 4, 5)
    val squaredNumbers = number.map { it * it }
    println(squaredNumbers) // Output: [1, 4, 9, 16, 25]
}

fun addNum(x: Int, y: Int): Int {
    return x + y
}

fun calculation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
