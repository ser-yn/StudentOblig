
package com.example.studentoblig.data

import com.example.studentoblig.R
import com.example.studentoblig.model.Animal

//This class holds functions to load the data from the resource folder, and creates
//a list of them using Instances of the Animal class
class Datasource {
    fun loadAnimals(): List<Animal> {
        return listOf<Animal>(
            Animal(R.string.animal1, R.drawable.bug),
            Animal(R.string.animal2, R.drawable.cow),
            Animal(R.string.animal3, R.drawable.lion),
            Animal(R.string.animal4, R.drawable.owl),
            Animal(R.string.animal5, R.drawable.whale),
            Animal(R.string.animal6, R.drawable.wolf)
        )
    }
}