package com.example.studentoblig.data

import android.app.Application
import com.example.studentoblig.R
import com.example.studentoblig.model.Animal

// Class which extends the app to hold the List of Animals
// Globally available, when created animalList is instantiated
// MutableList so Elements can be added and deleted

class GlobalListHolder : Application() {
    companion object {
        lateinit var animalList: MutableList<Animal>
    }

    override fun onCreate() {
        super.onCreate()
        animalList = createAnimalList()
    }

    private fun createAnimalList(): MutableList<Animal> {
        return mutableListOf<Animal>(
            Animal(R.string.animal1, R.drawable.bug),
            Animal(R.string.animal2, R.drawable.cow),
            Animal(R.string.animal3, R.drawable.lion),
            Animal(R.string.animal4, R.drawable.owl),
            Animal(R.string.animal5, R.drawable.whale),
            Animal(R.string.animal6, R.drawable.wolf)
        )
    }
}