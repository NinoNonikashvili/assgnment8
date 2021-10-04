package com.example.exam3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class updateData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        findViewById<Button>(R.id.save).setOnClickListener{ save()}
    }

    fun save(){
        val updatedDate = User(findViewById<EditText>(R.id.updatedName).text.toString(),
            findViewById<EditText>(R.id.updatedLastname).text.toString(),
            findViewById<EditText>(R.id.updatedEmail).text.toString())
        var returnedData: Intent = Intent()
        returnedData.putExtra("updtedData", updatedDate)
        setResult(Activity.RESULT_OK, returnedData )
        finish()

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
