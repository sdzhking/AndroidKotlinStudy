package com.sdzking.activitylifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
    }
}