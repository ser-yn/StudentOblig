package com.example.studentoblig.data

import com.example.studentoblig.R
import com.example.studentoblig.model.Animal

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