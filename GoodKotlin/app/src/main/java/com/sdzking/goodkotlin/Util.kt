package com.sdzking.goodkotlin

class Util {

    fun doAction1() {
        println("do action1")
    }

    companion object{ //伴生类
        @JvmStatic //真正的静态方法需要加注解
        fun doAction2() {
            println("do action2")
        }
    }
}