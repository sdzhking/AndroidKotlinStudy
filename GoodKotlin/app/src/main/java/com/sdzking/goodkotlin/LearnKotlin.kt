package com.sdzking.goodkotlin

import java.lang.IllegalArgumentException
import kotlin.math.max
import kotlin.math.min

fun main() {
    println("hello world")

    val good = 9
    println(good)

    var good2 = 10
    println("good2=$good2")
    good2 = 123
    println("good2=$good2")

    var good3 = "wd12"
    println("good3=$good3")

    var a: Int = 100
    a = a * 10
    println(a)

    println(largerNumber(good2, a))
    println(minNumber2(good2, a))
    println(getScore("zhang"))
    //println(checkNumber(a))

    for (i in 0 until 10 step 3) println(i)
    for (i in 10 downTo 1 step 3) println(i)

    val p = Person("wuxin", 20)
//    p.name = "WuXin"
    p.eat()

    val student = Student("a123", 5, "zhang", 23)
    student.eat()
    val student3 = Student("a1546")
    val student2 = Student()
    student2.eat()
    student2.name = "zhang"
    student2.eat()
    student2.name.lettersCount()
    student2.name.reversed()
    doStudy(student2)

    val phone1 = Cellphone("小米", 1999.99)
    val phone2 = Cellphone("小米", 1999.99)

    println(phone1)
    println("phone1 equals phone2 " + (phone1 == phone2))


    Singleton.bookinfo()
    val book1 = Singleton
    book1.bookname = "语文"
    book1.bookinfo()
    val book2 = Singleton
    book2.price = 562
    book2.bookinfo()

    println("==============不可变列表========")
    val list = listOf("apple", "orange", "banana", "pear", "grape")
    printListItems(list)

    println("==============可变列表========")
    val fruitslist = mutableListOf("apple", "orange", "banana", "pear", "grape")

    fruitslist.add("watermelon")

    printListItems(fruitslist)
    println("==============可变列表排序========")
    fruitslist.sortBy { it }

    printListItems(fruitslist)

    println("==============可变set========")
    val fruitsSet = mutableSetOf("apple", "orange", "banana", "pear", "grape")

    fruitsSet.add("watermelon")
    println("-------第一遍可变set---------")
    for (fruit in fruitsSet) {
        println(fruit)
    }

    println("-------第二遍可变set---------")
    for (fruit in fruitsSet) {
        println(fruit)
    }

    println("==============map集合========")
    val map = mutableMapOf("apple" to 1, "banana" to 2, "orange" to 3, "pear" to 4)

    for ((fruit, number) in map) {
        println("fruit is $fruit, number is $number")
    }
    println("==============集合函数式api========")
    println("最长的水果单词是${fruitslist.maxByOrNull { it.length }}")

    val newFruitslist = fruitslist.map { it.uppercase() }
    printListItems(newFruitslist)
    println("-------少于等于5个单词的水果---------")
    val newList = fruitslist.filter { it.length <= 5 }.map { it.uppercase() }
    printListItems(newList)
    println("-------any 和 all---------")
    val anyResult = fruitslist.any { it.length <= 5 }
    val allResult = fruitslist.all { it.length <= 5 }
    println("anyresult is $anyResult, allresult is $allResult")

    println("==============线程写法========")
    Thread { println("Thread is running") }.start()

    doStudy(null)

    eatFruits(fruitslist)

    println("==============函数with用法========")
    eatFruitsWith(fruitslist)
    println("==============函数run用法========")
    eatFruitsRun(fruitslist)
    println("==============函数Apply用法========")
    eatFruitsApply(fruitslist)
    println("==============函数静态方法========")
    Util.doAction2()

    doSomething()

    println("==============密封类优化========")
    // getResultMsg getResultSMsg


}

//密封类优化之前
fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
    else -> throw IllegalArgumentException()
}

//密封类优化之后
fun getResultSMsg(result: ResultS) = when (result) {
    is SuccessS -> result.msg
    is FailureS -> result.error.message
}

fun eatFruits(fruitslist: MutableList<String>) {

    val builder = StringBuilder()
    builder.append("Start eating fruits.\n")
    for (fruit in fruitslist) {
        builder.append(fruit).append("\n")
    }
    builder.append("Ate all fruits")
    val result = builder.toString()
    println(result)
}

fun eatFruitsWith(fruitslist: MutableList<String>) {

    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in fruitslist) {
            append(fruit).append("\n")
        }
        append("Ate all fruits")
        toString()
    }
    println(result)
}

fun eatFruitsRun(fruitslist: MutableList<String>) {

    val result = StringBuilder().run {
        append("Start eating fruits.\n")
        for (fruit in fruitslist) {
            append(fruit).append("\n")
        }
        append("Ate all fruits")
        toString()
    }
    println(result)
}

fun eatFruitsApply(fruitslist: MutableList<String>) {

    val result = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in fruitslist) {
            append(fruit).append("\n")
        }
        append("Ate all fruits")
        toString()
    }
    println(result)
}


private fun printListItems(newList: List<String>) {
    for (fruit in newList) {
        println(fruit)
    }
}

private fun doStudy(student2: Student?) {
    student2?.readBooks()
    student2?.doHomework()
}

private fun doStudy2(student2: Student?) {
    student2?.let {
        it.readBooks()
        it.doHomework()
    }

}

fun getTextLength(text: String?) = text?.length ?: 0

fun largerNumber(number1: Int, number2: Int): Int {
    return max(number1, number2)
}

fun minNumber2(number1: Int, number2: Int) = min(number1, number2)

fun largarNumber2(a: Int, b: Int) = if (a > b) a else b

fun getScore(name: String) = when (name) {
    "zhang" -> 56
    "wu" -> 22
    else -> 0
}

fun checkNumber(num: Number) = when (num) {
    is Int -> println("这是一个数字")
    is Double -> println("这是一个DOUNBE")
    else -> println("我针的不知道了")
}



