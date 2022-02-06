package com.example.studentoblig.model

import android.graphics.drawable.Drawable

// Data class which holds animal Pictures and Names
// I use Annotations, to be sure that nothing get's mixed up, since both resources are of type int
data class Animal(
    val stringResource: String,
    val imageResource: Drawable?
){
}