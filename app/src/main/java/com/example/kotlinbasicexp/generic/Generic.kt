package com.example.kotlinbasicexp.generic

/**
 *
 *
 */

fun main() {
// Example with String
    printItem("Hello, World!") // Output: Hello, World!

    // Example with Int
    printItem(42) // Output: 42

    // Example with List
    printItem(listOf(1, 2, 3)) // Output: [1, 2, 3]

    // Example with Custom Class
    val person = Person("Alice", 30)
    printItem(person) // Output: Person(name=Alice, age=30)}
}

/**
 * Generic Functions:
 */
fun <T> printItem(item: T) {
    println(item)
}

data class Person(val name: String, val age: Int)

/**
 * Generic Classes
 */
