package com.sdzking.retrofittest

import okhttp3.CacheControl
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface ExampleService {

    //请求地址类似 GET "http://example.com/get_data.json"
    @GET("get_data.json")
    fun getData(): Call<Data>

    //请求地址类似 GET "http://example.com/<page>/get_data.json"
    @GET("{page}/get_data.json")
    fun getDataPage(@Path("page") page: Int): Call<Data>

    //请求地址类似 GET "http://example.com/get_data.json?u=<user>&t=<token>"
    @GET("get_data.json")
    fun getDataParames(
        @Query("u") user: String,
        @Query("t") token: String
    ): Call<Data>

    //请求地址类似 DELETE http://example.com/data/<id>"
    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    //POST 提交参数 POST http://example.com/data/create
    //{"id":1, "content": "the description for this data"}
    @POST("data/create")
    fun createData(@Body data: Data): Call<ResponseBody>

    /**
     * 添加header信息
     */
    //请求地址类似 GET http://example.com/get_data.json
    // User-Agent: okhttp
    // Cache-Control: max-age=0
    //静态写法
    @Headers("User-Agent: okhttp", "Cache-Control: max-age=0")
    @GET("get_data.json")
    fun getDataHeader(): Call<Data>

    //动态写法
    @GET("get_data.json")
    fun getDataHeaders(
        @Header("User-Agent") userAgent: String,
        @Header("Cache-Control") cacheControl: String
    ): Call<Data>



}