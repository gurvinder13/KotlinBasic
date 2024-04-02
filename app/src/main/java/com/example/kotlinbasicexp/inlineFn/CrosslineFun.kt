package com.example.kotlinbasicexp.inlineFn

/**
 * crossinline forbids non-local returns in a lambda passed to an inline function
 *
 * In Kotlin, crossinline is a modifier used in higher-order functions to ensure
 * that a lambda passed to the function cannot suspend or return from the enclosing function.
 * This restriction prevents the lambda from altering the control flow of the enclosing function.
 */

fun main() {
// Define a lambda for addition
    val addition = { a: Int, b: Int -> a + b }
    // Perform addition using the higher-order function
    val result = performOperation(5, 3, addition)
    println("Result of addition: $result") // Output: Result of addition: 8
}

inline fun performOperation(x: Int, y: Int, crossinline operation: (Int, Int) -> Int): Int {
    // We cannot directly call the crossinline-marked lambda here
    // But we can pass it to another function that accepts a lambda
    return operation(x, y)
}

