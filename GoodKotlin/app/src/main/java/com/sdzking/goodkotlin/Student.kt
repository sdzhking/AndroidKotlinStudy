package com.sdzking.goodkotlin

class Student(val sno: String = "", val grade: Int = 0, name: String = "", age: Int = 0) : Person(name, age), Study {
    init {
        println("sno is $sno")
        println("grade is $grade")
    }

    constructor(name: String, age: Int = 12) : this("",0, name, age) {

    }
    constructor():this("", 0) {
        
    }

    override fun readBooks() {
        println("$name is Reading")
    }

//    override fun doHomework() {
//
//        println("$name is dong homework")
//    }
}