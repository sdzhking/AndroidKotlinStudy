package com.sdzking.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        button.setOnClickListener {
            toastText("click button")
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            val intentHide = Intent("com.sdzhking.activitytest.SecondActivity")
            intentHide.addCategory(Intent.CATEGORY_DEFAULT)
            startActivity(intentHide)
        }
        button_finish.setOnClickListener { finish() }
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
}