package com.example.studentoblig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.studentoblig.data.GlobalListHolder

class RemoveActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove)

        spinner =  findViewById(com.example.studentoblig.R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            GlobalListHolder.animalList)
            .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun removeEntry(view: View){
        GlobalListHolder.animalList.removeAt(spinner.selectedItemPosition)
    }
}