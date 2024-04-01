package com.example.kotlinbasicexp.extensionFn

import android.view.View

/**
 * Extension functions in Kotlin allow you to add new functions to existing classes without
 * modifying their source code.
 */

fun main() {
    val msg = "Hello world"
    val result = msg.addExclamation()
    val length = msg.safeLength()
    println(result + length)
    println(msg.hasSpaces)
}

fun String.addExclamation(): String {
    return "$this!"
}

//Nullable Receiver:
fun String?.safeLength(): Int {
    return this?.length ?: 0
}

// Extension Properties:
val String.hasSpaces: Boolean
    get() = this.contains(" ")

// View-related Extensions in Android Development
fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

// Usage
//someView.hide()
