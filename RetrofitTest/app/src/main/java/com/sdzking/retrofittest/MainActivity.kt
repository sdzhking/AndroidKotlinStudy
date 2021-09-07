package com.sdzking.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sdzking.retrofittest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import kotlin.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getAppDataBtn.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.13.244:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val appService = retrofit.create(AppService::class.java)

            val appService2 = ServiceCreator.create(AppService::class.java)

            val appService3 = ServiceCreator.create<AppService>()

            appService.getAppData().enqueue(object : Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    val list = response.body()
                    if (list != null) {

                        for (app in list) {
                            Log.d(TAG, "id is ${app.id} ")
                            Log.d(TAG, "name is ${app.name} ")
                            Log.d(TAG, "version is ${app.version} ")
                        }
                    }

                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }

            })


            //使用协程调用网络请求
            val job = Job()
            val scope = CoroutineScope(job)
            scope.launch {
                //处理代码
                getAppData()
            }
            scope.cancel()

        }
    }

    suspend fun getAppData() {
        try {
            val applist = ServiceCreator.create<AppService>().getAppData().await()
            if (applist != null) {

                for (app in applist) {
                    Log.d(TAG, "2id is ${app.id} ")
                    Log.d(TAG, "2name is ${app.name} ")
                    Log.d(TAG, "2version is ${app.version} ")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))

                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            })
        }
    }
}