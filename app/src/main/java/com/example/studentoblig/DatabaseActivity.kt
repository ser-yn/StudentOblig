package com.example.studentoblig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.studentoblig.adapter.ItemAdapter
import com.example.studentoblig.data.GlobalListHolder

class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        val myDataset = GlobalListHolder.animalList
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
    }

    fun startAdd(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun DeleteEntry(view: View){
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
    }

    fun sortData(view: View){
        //GlobalListHolder.animalList.sortBy { it.stringResource.compareTo("a") }
        val myDataset = GlobalListHolder.animalList
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
    }
}