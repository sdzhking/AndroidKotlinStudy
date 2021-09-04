package com.sdzking.activitytest

import android.app.Activity

object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity (activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity (activity: Activity) {
        activities.remove(activity)
    }

    fun finishall() {
        for(activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }
}