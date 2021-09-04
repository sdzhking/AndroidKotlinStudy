package com.sdzking.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.util.Log
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : BaseActivity() {
    private val TAG = "ThirdActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        Log.d(TAG, "onCreate: $taskId")
        button3.setOnClickListener {
            ActivityCollector.finishall()
            Process.killProcess(Process.myPid())
        }
    }
}