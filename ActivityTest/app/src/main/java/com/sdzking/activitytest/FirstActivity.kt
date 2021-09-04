package com.sdzking.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaseActivity() {
    private val TAG = "FirstActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        Log.d(TAG, "onCreate: $this, Task id is $taskId")


        button.setOnClickListener {
            toastText("click button")
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)

//            val data ="Hello SecondActivity"
//            val intentHide = Intent("com.sdzhking.activitytest.SecondActivity")
//            intentHide.putExtra("extra_data", data)
//            startActivity(intentHide)

            startActivity(Intent(this, FirstActivity::class.java))
        }
        button_finish.setOnClickListener { finish() }

        getrspbtn.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult(intent, 1)
            SecondActivity.actionStart(this, "data1", "data2")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> toastText("add item")
            R.id.remove_item ->  toastText("remove item")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toastText(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1-> if (resultCode == RESULT_OK) {
                val returnData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "return data is $returnData")
            }
        }
    }
}