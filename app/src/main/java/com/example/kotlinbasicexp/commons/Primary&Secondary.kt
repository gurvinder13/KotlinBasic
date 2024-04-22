package com.example.kotlinbasicexp.commons

fun main(){
    var user = User("Guri", 30)
    var user2 = User("Guri", 30,true)

}

 class User(val name: String, val age: Int) {
     private var fName: String = name
     private var uAge: Int = age

     init {
         println("User name is $fName & age is $uAge")
     }

     // Change the parameter name in the secondary constructor
     constructor(Mname: String, age: Int, isSecondary: Boolean = true) : this(Mname,age) {
         if (isSecondary) {
             println("User 2 name is $Mname & age is $age")
         }
     }
 }