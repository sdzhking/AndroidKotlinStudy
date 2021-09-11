package com.sdzking.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.*
import com.sdzking.jetpacktest.ViewModel.MainViewModel
import com.sdzking.jetpacktest.ViewModel.MainViewModelFactory
import com.sdzking.jetpacktest.entity.AppDatabase
import com.sdzking.jetpacktest.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Character.UnicodeBlock.of
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
            //refreshCounter()
        }

        clearBtn.setOnClickListener {
            viewModel.clear()
            //refreshCounter()
        }
        //refreshCounter()
//        viewModel.counter.observe(this, Observer { count ->
//            infoText.text = count.toString()
//        })
        //lifedata-ktx 2.2之后的写法
        viewModel.counter.observe(this) { count ->
            infoText.text = count.toString()
        }

        lifecycle.addObserver(MyObserver(lifecycle))

        getUserBtn.setOnClickListener {
            val userId = (0..10000).random().toString()
//            viewModel.getUser(userId)
            viewModel.refresh()
        }
        viewModel.user.observe(this) { user ->

            infoText.text = user.firstName

            Log.d("TAG", "onCreate:  datachange")
        }

        viewModel.refreshResult.observe(this) {
            Log.d("TAG", "refreshResult:  datachange")
        }

        roomDataMethod()
    }

    private fun roomDataMethod() {
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updatUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("TAG", "roomDataMethod: ${user.toString()}")
                }
            }
        }


    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}