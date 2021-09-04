package com.sdzking.activitytest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {

    val TAG = "SecondActivity"

    companion object{
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
        fun actionStartApply(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java).apply {

                putExtra("param1", data1)
                putExtra("param2", data2)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.hide()

        Log.d(TAG, "onCreate: Task id is $taskId")

        val extraData = intent.getStringExtra("extra_data")
        Log.d(TAG, "onCreate: extradata is $extraData")
        val extraparam1 = intent.getStringExtra("param1")
        Log.d(TAG, "onCreate: extradata is $extraparam1")
        val extraparam2 = intent.getStringExtra("param2")
        Log.d(TAG, "onCreate: extradata is $extraparam2")

        button2.setOnClickListener {
            //backData()
            //startActivity(Intent(this, ThirdActivity::class.java))
            AlertDialog.Builder(this).apply {
                setTitle("This is a Dialog")
                setMessage("Something important")
                setCancelable(false)
                setPositiveButton("OK"){ dialog, v->
                }
                setNegativeButton("Cancel") {dialog, which ->}
                show()
            }
        }
    }

    private fun backData() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello, FirstActivity")
        setResult(RESULT_OK, intent)
        finish()
    }


    override fun onBackPressed() {
        backData()
    }
}