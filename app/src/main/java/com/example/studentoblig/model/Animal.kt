package com.example.studentoblig.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Data class which holds animal Pictures and Names
// I use Annotations, to be sure that nothing get's mixed up, since both resources are of type int
data class Animal (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int){
}