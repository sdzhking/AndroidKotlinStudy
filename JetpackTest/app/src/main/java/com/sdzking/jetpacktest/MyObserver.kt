package com.sdzking.jetpacktest

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {

    private val TAG = "MyObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun actionStart() {
        Log.d(TAG, "actionStart: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun actionStop() {
        Log.d(TAG, "actionStop: ")
    }
}