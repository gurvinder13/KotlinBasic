package com.example.kotlinbasicexp.lambdaExp

import android.media.VolumeShaper.Operation

/**
 *In Kotlin, a lambda expression is a concise way to express anonymous functions
 * {}: The curly braces define the lambda expression.
 * parameters: Optional parameters can be specified before the arrow ->.
 * If the lambda has no parameters, you can omit the parameter list.
 * ->: Separates the parameters from the body of the lambda.
 * body: Contains the code to be executed when the lambda is invoked.
 */

fun main() {
    val sum = { a: Int, b: Int -> a + b }
    val result = sum(3, 4)
    println(result)

    // Lambda without parameters:
    val sayHello = { println("Hello world") }
    sayHello()

    // Lambda with parameters:
    val add = { a: Int, b: Int -> a + b }
    println(add(3, 5)) // Output: 8

    //  Lambda as a function parameter
    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }
 // Todo we can write like this also
   /* fun multiNum(x: Int, y: Int):Int{
       return x* y
    }
    val mult = performOperation(3, 7 , ::multiNum) */
    val multi = performOperation(3, 7) { x, y -> x * y }

    println(multi)
}


