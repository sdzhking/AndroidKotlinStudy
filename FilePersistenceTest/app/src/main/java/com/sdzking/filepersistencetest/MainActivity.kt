package com.sdzking.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sdzking.filepersistencetest.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storeStr = load()
        if (storeStr.isNotEmpty()) {
            binding.input.setText(storeStr)
            binding.input.setSelection(storeStr.length)
            Toast.makeText(this, "回复数据成功", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        save(binding.input.text.toString())
    }

    fun save(str: String) {
        try {
            val outputStream = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            writer.use { it.write(str) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}