package com.sdzking.goodkotlin

import kotlin.text.StringBuilder

/**
 * kotlin高阶函数应用
 *
 */
inline fun num1AndNum2(number1: Int, number2: Int, operation: (Int, Int) -> Int): Int {
    return operation(number1, number2)
}

fun plus(number1: Int, number2: Int): Int {
    return number1 + number2
}

fun minus(number1: Int, number2: Int): Int {
    return number1 - number2
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

inline fun inlineTest(block1:()->Unit, noinline block2: () -> Unit) {

}