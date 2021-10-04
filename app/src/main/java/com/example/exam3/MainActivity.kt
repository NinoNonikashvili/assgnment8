package com.example.exam3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    val list = mutableListOf<User>()
    var newData : User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData(list)
        val myRecyclerView = findViewById<View>(R.id.rv) as RecyclerView
        myRecyclerView.adapter = Adapter(list) { position -> onItemClick(position) }
        myRecyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        findViewById<Button>(R.id.add).setOnClickListener{ sendToUpdate()}


    }
    private fun onItemClick(position :Int) : User? {
     sendToUpdate()
       return newData

    }

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult? ->

            if (result != null) {
                if (result.resultCode == RESULT_OK) {

                     newData = result.data?.getParcelableExtra("updatedData") as? User
                    Toast.makeText(this, "${newData?.name}", Toast.LENGTH_SHORT).show()


                }
            }

        }

       fun sendToUpdate() {

           val intent: Intent = Intent(this, updateData::class.java)
           resultContract.launch(intent)

       }



    fun setData(list: MutableList<User>){
        list.add(User("eka", "li", "email@gmail.com"))
        list.add(User("ia", "li", "email@gmail.com"))
        list.add(User("elene", "li", "email@gmail.com"))
        list.add(User("ana", "li", "email@gmail.com"))   }

}