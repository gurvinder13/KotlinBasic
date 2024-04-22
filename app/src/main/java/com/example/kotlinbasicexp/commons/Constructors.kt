package com.example.kotlinbasicexp.commons

/**
 * A constructor is a type or kind of member function, which is used to initialize
 * the properties of a class. Whenever you create an object of a class,
 * then the constructor will be called first automatically and after that other methods
 * will be called(on function call).
 */
fun main() {
    var student = Student("Gurvinder", 10)
    print(student.id)
}

class Student(private var name: String) {
    var id: Int = -1

    init {
        println("Student has got a name as $name")
    }
    /**
     *     Note: You must call the primary constructor from the secondary constructor explicitly.
     *     Also, the property of the class can’t be declared inside the secondary constructor.
     *     For example, you can't declare id as the property of the class in the secondary constructor:
     *
     */
    constructor( name: String, id: Int) : this(name) {
        // the Body of the secondary constructor is called after the init block
        this.id = id
    }

   /* //this will give an error because here we are declaring a property id of
         the class in the secondary constructor, which is not allowed
    constructor(sectionName: String, var id: Int) this(sectionName) {

    }*/
}

class Person(_name: String, _age: Int, _salary: Int) {
    // Member Variables (Properties) of the class
    var name: String
    var age: Int
    var salary: Int

    // Initializer Block
    init {
        this.name = _name
        this.age = _age
        this.salary = _salary
        println("Initialized a new Person object with Name = $name , age = $age and salary = $salary")
    }
}
