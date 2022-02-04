package com.example.studentoblig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.studentoblig.data.GlobalListHolder

class QuizActivity : AppCompatActivity() {

    private var rightCounter: Int = 0
    private var wrongCounter: Int = 0

    //I change the Text according to the amount of given answers
    //Somehow it was not possible to initialize them right away
    //I didn't want to create the connection to the TextView new everytime i used it
    //So i used lateinit and initialize it in the oncreate function
    private lateinit var textViewRight: TextView
    private lateinit var textViewWrong: TextView

    private lateinit var imgView: ImageView

    private lateinit var butAnsOne: Button
    private lateinit var butAnsTwo: Button
    private lateinit var butAnsThree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        textViewRight = findViewById(R.id.textView_rightAnswers)
        textViewWrong = findViewById(R.id.textView_wrongAnswers)

        imgView = findViewById(R.id.imageView)

        butAnsOne = findViewById(R.id.buttonAnswerOne)
        butAnsTwo = findViewById(R.id.buttonAnswerTwo)
        butAnsThree = findViewById(R.id.buttonAnswerThree)

        textViewRight.text = "Right answers: 0"
        textViewWrong.text = "Wrong answers: 0"

        setPictureAndAnswersRandom()
    }

    fun setPictureAndAnswersRandom(){
        val listSize: Int = GlobalListHolder.animalList.size
        var rightAnswer = (0 until listSize).random()
        var wrongAnswerOne = (0 until listSize).random()
        var wrongAnswerTwo = (0 until listSize).random()
        //Not to get the same Value Twice I firstly check the first wrong then the second wrong answer
        //The while loop gets broken once it's not the same value anymore
        while (true) {
            if (rightAnswer==wrongAnswerOne){
                wrongAnswerOne = (0 until listSize).random()
            }
            else{
                break
            }
        }
        while (true) {
            if (rightAnswer==wrongAnswerTwo || wrongAnswerOne==wrongAnswerTwo){
                wrongAnswerTwo = (0 until listSize).random()
            }
            else{
                break
            }
        }

        imgView.setImageResource(GlobalListHolder.animalList[rightAnswer].imageResourceId)

        butAnsOne.setText(GlobalListHolder.animalList[rightAnswer].stringResourceId)
        butAnsTwo.setText(GlobalListHolder.animalList[wrongAnswerOne].stringResourceId)
        butAnsThree.setText(GlobalListHolder.animalList[wrongAnswerTwo].stringResourceId)
    }

    fun evaluateAnswer(view: android.view.View) {
        setPictureAndAnswersRandom()
    }
}