package com.example.studentoblig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.studentoblig.data.GlobalListHolder
import com.example.studentoblig.model.Animal


class AddActivity : AppCompatActivity() {

    private lateinit var butAddToData: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        butAddToData = findViewById(R.id.buttonAddToDatabase)
        imageView = findViewById(R.id.imageViewAddImage)
        textView = findViewById(R.id.editTextPersonName)
    }

    //Got this from a tutorial, don't really know how it works
    fun getImage(view: View) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

        butAddToData.isEnabled = true
    }

    //Needed for the startActivityForResultPart
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== IMAGE_REQUEST_CODE && resultCode== RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }

    fun addToData(view: View) {
        if(textView.text.trim().length==0){
            Toast.makeText(this, "You need to enter a name", Toast.LENGTH_SHORT).show()
        }
        else{
            //GlobalListHolder.animalList.add(Animal(R.id.editTextPersonName, R.drawable.owl))
            Toast.makeText(this, "Cool name", Toast.LENGTH_SHORT).show()
        }
    }
}