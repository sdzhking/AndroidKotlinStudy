package com.sdzhking.kotlinlearning

inline fun runRunnable(crossinline  block: () -> Unit) {
    val runnable = Runnable {
        println("runRunnable begin")
        block()
        println("runRunnable end")
    }
    runnable.run()
}

fun main() {
    println("main start")
    runRunnable() {
        println("lambda start")
        return@runRunnable
        println("lambda end")
    }
    println("main end")
}