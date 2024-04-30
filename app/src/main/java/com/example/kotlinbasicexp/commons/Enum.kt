package com.example.kotlinbasicexp.commons

/**
 *  An enum class in Kotlin is a special kind of class that represents a fixed set of constants,
 *   also known as enum constants. Enums provide a way to define a type with a limited number of possible values
 *
 *   Enum Constants:
 * Enum constants are predefined instances of the enum class.
 * Each enum constant is separated by commas and represents a single value within the enum class.
 * Enum constants are typically written in uppercase by convention.
 *
 * Properties and Methods:
 * Enums can have properties and methods, just like regular classes.
 * You can define properties and methods within the enum class, and each enum constant can access these properties and methods.
 */
enum class Day(var dayOfWeek: Int) {
    MONDAY(1 ),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),;

    fun getDayName(): String {
     return "[${dayOfWeek}] -> $MONDAY"
    }
    companion object {
        fun getNumberOfDays() = values().size
    }
}

/*enum class Day {
    MONDAY {
        override fun nextDay() = TUESDAY
    },
    TUESDAY {
        override fun nextDay() = WEDNESDAY
    },
    WEDNESDAY {
        override fun nextDay() = THURSDAY
    },
    THURSDAY {
        override fun nextDay() = FRIDAY
    },
    FRIDAY {
        override fun nextDay() = SATURDAY
    },
    SATURDAY {
        override fun nextDay() = SUNDAY
    },
    SUNDAY {
        override fun nextDay() = MONDAY
    };

    abstract fun nextDay(): Day
}*/

fun main(){
    for (day in Day.values()){
        println("[${day.ordinal}] -> ${day.name} (${day.dayOfWeek}^ day of the week)")
    }
   println(Day.MONDAY.getDayName())
    println(Day.getNumberOfDays())
}