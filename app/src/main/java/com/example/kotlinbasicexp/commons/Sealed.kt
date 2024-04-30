package com.example.kotlinbasicexp.commons

import com.example.kotlinbasicexp.MainActivity

/**
 *  A sealed class in Kotlin is a type of class that represents a restricted hierarchy of classes,
 *   where all subclasses must be defined within the same file as the sealed class itself.
 *    Sealed classes are often used to model restricted sets of possible types, such as a sealed sum
 *     type where a value can be one of a fixed set of possible types
 */
// Attempt to extend the sealed class outside the file
// This will result in a compilation error
// class Failure : Result()

// Attempt to declare sealed class as open
// This will result in a compilation error
// open sealed class Result

// Attempt to declare sealed class as final
// This will result in a compilation error
// final sealed class Result
sealed class Result {
    // Subclasses of the sealed class declared within the same file
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()

    companion object Main {

    }
}
