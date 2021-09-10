package com.sdzking.jetpacktest.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

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
}