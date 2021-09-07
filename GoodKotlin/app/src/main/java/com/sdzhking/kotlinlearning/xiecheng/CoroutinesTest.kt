package com.sdzhking.kotlinlearning.xiecheng

import android.telecom.Call
import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

/**
 * 协程相关内容
 */
fun main() {

//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine scope finished")
//    }
//    Thread.sleep(1000)

//
//    runBlocking {
//        println("block codes run in coroutine scope")
//        delay(1500)
//        println("block codes run in coroutine scope finished")
//    }

//    runBlocking {
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }

//
//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(10000) {
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)

//    runBlocking {
//        coroutineScope {
//            launch {
//                for (i in 1..10) {
//                    println(i)
//                    delay(100)
//                }
//            }
//        }
//        println("coroutineScope finished")
//    }
//
//    println("runBlocking finished")

    /**=======上面的方法不建议使用 会阻塞========== */

    /**=======下面的是协程正确的用法========== */
//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        //处理代码
//    }
//    scope.cancel()
    /** 结束*/

//    runBlocking {
//        val start = System.currentTimeMillis()
//        val result = async {
//            delay(1000)
//            5 + 5
//        }.await()
//
//        val result2 = async {
//            delay(1000)
//            4 + 6
//        }.await()
//        println("result is ${result + result2}")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} ms.")
//    }

    runBlocking {
        val start = System.currentTimeMillis()
        val result = async {
            delay(1000)
            5 + 5
        }

        val result2 = async {
            delay(1000)
            4 + 6
        }
        println("result is ${result.await() + result2.await()}")
        val end = System.currentTimeMillis()
        println("cost ${end - start} ms.")
    }

    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }

        println(result)
    }
}

suspend fun printDot() = coroutineScope {
    launch {

        println("2")
        delay(500)
    }
}

suspend fun request(address: String): String {
    return suspendCoroutine { continuation ->
    }
}

