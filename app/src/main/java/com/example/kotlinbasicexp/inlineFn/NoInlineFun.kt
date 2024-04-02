package com.example.kotlinbasicexp.inlineFn

/**
 * Assume that we do not want all of the lambdas passed to an inline function to be inlined,
 * in that case, we can mark those function parameters with the noinline modifier
 * In Kotlin, the noinline modifier is used in higher-order functions to specify
 * that a particular lambda parameter should not be inlined by the compiler.
 */

fun main() {
    higherOrderFunction({

    },{

    })
   getData(
       {
           println("start abc")
       },{
           println("start xyz")
       }
   )
}

inline fun getData(abc: () -> Unit, noinline xyz: () -> Unit) {
    abc()
    xyz()
}

inline fun higherOrderFunction(normalLambda: () -> Unit, noinline noInlineLambda: () -> Unit) {
    normalLambda()
    noInlineLambda()
}
