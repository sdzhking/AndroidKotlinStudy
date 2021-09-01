package com.sdzking.goodkotlin

object Singleton {
    var bookname = "";
    var price = 190;

    fun bookinfo() {
        println("bookname is $bookname, price is $price")
    }
}