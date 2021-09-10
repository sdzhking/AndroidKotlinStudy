package com.sdzking.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.*
import com.sdzking.jetpacktest.ViewModel.MainViewModel
import com.sdzking.jetpacktest.ViewModel.MainViewModelFactory
import com.sdzking.jetpacktest.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Character.UnicodeBlock.of

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
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this){ user ->

            infoText.text = user.firstName

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