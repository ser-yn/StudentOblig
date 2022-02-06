package com.example.studentoblig.data

import android.app.Application
import androidx.core.graphics.drawable.toDrawable
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
            Animal("Owl", getDrawable(R.drawable.owl)),
            Animal("Whale", getDrawable(R.drawable.whale)),
            Animal("Wolf", getDrawable(R.drawable.wolf)),
            Animal("Bug", getDrawable(R.drawable.bug)),
            Animal("Cow", getDrawable(R.drawable.cow)),
            Animal("Lion", getDrawable(R.drawable.lion)),
        )
    }
}