package com.example.studentoblig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.studentoblig.adapter.ItemAdapter
import com.example.studentoblig.data.GlobalListHolder
import com.example.studentoblig.model.Animal

class DatabaseActivity : AppCompatActivity() {
    private var sortAlphabetical: Boolean = false

    private lateinit var myDataset: MutableList<Animal>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        GlobalListHolder.animalList.sortWith(compareBy { it.stringResource })
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, GlobalListHolder.animalList)
    }

    override fun onResume() {
        super.onResume()
        GlobalListHolder.animalList.sortWith(compareBy { it.stringResource })
        sortAlphabetical = false
        recyclerView.adapter?.notifyDataSetChanged()
    }

    fun startAdd(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun DeleteEntry(view: View){
        val intent = Intent(this, RemoveActivity::class.java)
        startActivity(intent)
    }

    //Sorts the names out of the StringResource, boolean which switches everytime
    //to toggle between aphabetical and counteralphabetical
    fun sortData(view: View){
        GlobalListHolder.animalList.sortWith(compareBy { it.stringResource })
        if (!sortAlphabetical){
            GlobalListHolder.animalList.reverse()
        }
        sortAlphabetical = !sortAlphabetical
        recyclerView.adapter?.notifyDataSetChanged()
    }
}