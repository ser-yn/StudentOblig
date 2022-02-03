package com.example.studentoblig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private var rightCounter: Int = 0;
    private var wrongCounter: Int = 0;

    private lateinit var textViewRight: TextView;
    private lateinit var textViewWrong: TextView;

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