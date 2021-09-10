package com.sdzking.jetpacktest.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sdzking.jetpacktest.Repository
import com.sdzking.jetpacktest.entity.User

class MainViewModel(countReserved: Int) : ViewModel() {
    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

    private val userLivedata = MutableLiveData<User>()
    //只对外显示名字
    val userName: LiveData<String> = Transformations.map(userLivedata){ user ->
        "${user.firstName} ${user.lastName}"
    }

//    fun getUser(userId: String): LiveData<User> {
//        return Repository.getUser(userId)
//    }


    private val userIdLiveData = MutableLiveData<String>()
    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) { userId ->
        Repository.getUser(userId)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }

}