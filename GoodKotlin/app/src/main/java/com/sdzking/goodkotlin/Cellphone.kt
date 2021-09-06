package com.sdzking.goodkotlin

data class Cellphone(val brand: String, val price: Double) {


    //泛型方法
    fun <T> method(param: T): T {
        return param
    }
}