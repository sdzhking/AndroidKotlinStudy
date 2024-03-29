package com.sdzking.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdzking.jetpacktest.entity.User

object Repository {
    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return liveData
    }

}