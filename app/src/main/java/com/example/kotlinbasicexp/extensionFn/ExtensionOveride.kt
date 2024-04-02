package com.example.kotlinbasicexp.extensionFn

fun main() {
    val str = "Hello"
    val result = str.addExclamation1() // Calls extension function
    println(result) // Output: Hello!

    val customStr = CustomString("Hi")
    val customResult = customStr.addExclamation1() // Calls overridden function
    println(customResult) // Output: Hi!
}

open class CustomString(val value: String) {
    open fun addExclamation1(): String {
        return value.addExclamation1() // No exclamation added in subclass
    }
}

fun String.addExclamation1(): String {
    return "$this!"
}

