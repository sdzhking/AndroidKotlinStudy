package com.sdzhking.kotlinlearning

inline fun printString1(str: String, block:(String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

fun main() {
    println("main start")
    val str = ""
     printString1(str) {s->
         println("lambda start")
         if (s.isEmpty()) return
         println(s)
         println("lambda end")
     }
    println("main end")
}