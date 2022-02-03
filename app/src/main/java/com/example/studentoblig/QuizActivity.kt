package com.example.studentoblig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private var rightCounter: Int = 0
    private var wrongCounter: Int = 0

    //I change the Text according to the amount of given answers
    //Somehow it was not possible to initialize them right away
    //I didn't want to create the connection to the TextView new everytime i used it
    //So i used lateinit and initialize it in the oncreate function
    private lateinit var textViewRight: TextView
    private lateinit var textViewWrong: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        textViewRight = findViewById(R.id.textView_rightAnswers)
        textViewWrong = findViewById(R.id.textView_wrongAnswers)
        textViewRight.text = "Right answers: 0"
        textViewWrong.text = "Wrong answers: 0"
    }


    fun evaluateAnswer(view: android.view.View) {
    }
}