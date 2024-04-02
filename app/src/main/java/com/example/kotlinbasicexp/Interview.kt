package com.example.kotlinbasicexp

fun main() {
    val list2 = arrayListOf("A", "A","A", "A")
    val list1 = cutList(list2)
    val size =list1.size // Ans: ??
    println(size)

}

private fun cutList(list1: ArrayList<String>): ArrayList<String> {
    val list2 = list1
    var index = 0
    while (index < list2.size) {
        if (list2[index] == "A") {
            list2.removeAt(index)
        } else {
            index++
        }
    }
    return list2

}