package com.example.kotlinbasicexp.inlineFn

/**
 * An Inline Function is declare with keyword Inline.
 * The use of Inline function enhances the performance of Higher Order function.
 * The Inline function tells the compiler to copy parameter and body and functions to the call side.
 *
 * It is used for to enhance the performance of the higher-order function.
 * It tells the compiler to copy parameters and functions to the call site.
 * That means Inline function instruct compiler to insert complete body of the function
 * whenever that function got used in the code. To use an inline function,
 * all you need to do is just add an inline keyword at the beginning of the function declaration.
 *
 * When to use inline functions?
 *
 * Use inline functions for performance-critical code or functions that are called frequently.
 * Avoid inlining large functions to prevent code bloat and longer compilation times.
 */

fun main() {
    guide()
    val result = square(5)
    println("Square of 5: $result")
    performOperation {
        println("Performing some action...")
    }
    operation(2, 2, ::add)

}

fun guide() {
    println("guide start")
    teach()
    println("guide end")

}

inline fun teach() {
    println("teach")
}

inline fun square(x: Int): Int {
    return x * x
}

inline fun performOperation(action: () -> Unit) {
    println("Start of operation")
    action() // Execute the passed lambda function
    println("End of operation")
}

fun add(x: Int, y: Int): Int {
    return x + y
}
// Higher order fun
inline fun operation(a: Int, b: Int, operation: (Int, Int) -> Int) {
    println(operation(a, b))
}

