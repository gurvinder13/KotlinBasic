package com.example.kotlinbasicexp.inlineFn

/**
 *
 *
 * Key points about reified:
 *
 * It can only be used with inline functions.
 * It can only be applied to type parameters of inline functions.
 * It allows you to access the actual type information of generic type parameters at runtime.
 * It's particularly useful for scenarios like creating instances of generic types,
 * checking types, or using reflection within inline functions.
 * It's not applicable to properties or non-inline functions.
 *
 * It is a special type of keyword that helps to access the information related to a class at runtime.
 * “reified” can only be used with inline functions. In Kotlin, the reified keyword is used in
 * combination with inline functions to enable the retrieval of generic type information at runtime.
 * This feature is not available in regular generic functions, but it becomes possible with
 * reified keyword within inline functions.
 */

fun main(){
  val type = getTypeName<Int>()
    println(type)
    printType<String>()
    printType<Float>()
    printType(Int)
}

inline fun  <reified T> getTypeName():String{
    return T::class.simpleName ?: "Unknown"
}

inline fun <reified T> printType() {
    println(T::class.simpleName)
}

inline fun <reified T> printType(obj: T) {
    println("The type of the object is: ${T::class.simpleName}")
}
