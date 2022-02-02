package com.example.studentoblig.data

import com.example.studentoblig.R
import com.example.studentoblig.model.Animal

//This class holds functions to load the data from the resource folder, and creates
//a list of them using Instances of the Animal class
class Datasource {
    fun loadAnimals(): List<Animal> {
        return listOf<Animal>(
            Animal(R.string.animal1),
            Animal(R.string.animal2),
            Animal(R.string.animal3),
            Animal(R.string.animal4),
            Animal(R.string.animal5),
            Animal(R.string.animal6)
        )
    }
}