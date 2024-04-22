package com.example.kotlinbasicexp.commons

/**
 * Type aliases provide alternative names for existing types.
 * If the type name is too long you can introduce a different shorter name and use the new one instead.
 * Kotlin supports type aliases through the typealias keyword
 * Using this we can rename the exiting data type
 */



fun main (){

      /*  println("Enter your name")
        val input = readlnOrNull() // readLine()
        println("My name is $input")*/
    println(getIntNumbers())

}
typealias IntegerList = List<Int>
typealias StringList = List<String>

fun getIntNumbers():IntegerList{
    return listOf(1,2,3,4)
}

fun getStringNumbers(): List<String>{
    return listOf("a","b","c")
}
fun getStringNumber(): StringList{
    return listOf("a","b","c")
}
