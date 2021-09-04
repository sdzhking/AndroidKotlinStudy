package com.sdzhking.kotlinlearning

import com.sdzking.goodkotlin.build
import com.sdzking.goodkotlin.minus
import com.sdzking.goodkotlin.num1AndNum2
import com.sdzking.goodkotlin.plus

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits. \n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Eat all fruits. \n")
    }
    println(result.toString())

    println("=============6.5高阶函数========")

    val number1 = 100
    val number2 = 80

    println("plus result is ${num1AndNum2(number1, number2, ::plus)}")
    println("minus result is ${num1AndNum2(number1, number2, ::minus)}")
    val result3 = num1AndNum2(number1, number2) { n1, n2 ->
        n1 * n2
    }
    println("result3 result is $result3")
}