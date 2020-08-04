package com.example.recyclerviewadddelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val positionText = findViewById<EditText>(R.id.positionText)
        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<ImageButton>(R.id.addButton)
        val deleteButton = findViewById<ImageButton>(R.id.deleteButton)

        val list = ArrayList<Double>()
        val layoutManager1 = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recycleView.layoutManager = layoutManager1
        val adapter1 = Adapter(list)
        recycleView.adapter=adapter1


        addButton.setOnClickListener {
            val text = positionText.text
            if (text!=null){
                for(i in 1..text.toString().toInt()){
                    list.add(Math.random())
                }
                adapter1.notifyDataSetChanged()
            }
        }

//        deleteButton.setOnClickListener{
//            val text = positionText.text
//            if(text!=null){
//                list.removeAt(text.toString().toInt())
//                adapter1.notifyItemRemoved(text.toString().toInt())
//            }
//        }

    }
}
