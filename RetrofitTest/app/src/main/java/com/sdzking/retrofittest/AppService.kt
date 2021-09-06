package com.sdzking.retrofittest

import retrofit2.http.GET
import retrofit2.Call

interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}