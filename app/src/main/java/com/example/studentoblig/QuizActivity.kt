package com.example.studentoblig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.studentoblig.data.GlobalListHolder

class QuizActivity : AppCompatActivity() {

    private var rightCounter: Int = 0
    private var wrongCounter: Int = 0

    private var rightButtonId: Int = 0
    private var pressedButtonId: Int = 0

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
    private lateinit var butCheck: Button
    private lateinit var butPress: Button

    //Find all the Buttons and Views on Creation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        textViewRight = findViewById(R.id.textView_rightAnswers)
        textViewWrong = findViewById(R.id.textView_wrongAnswers)

        imgView = findViewById(R.id.imageView)

        butAnsOne = findViewById(R.id.buttonAnswerOne)
        butAnsTwo = findViewById(R.id.buttonAnswerTwo)
        butAnsThree = findViewById(R.id.buttonAnswerThree)
        butCheck = findViewById(R.id.buttonCheck)

        textViewRight.text = "Right answers: 0"
        textViewWrong.text = "Wrong answers: 0"

        setPictureAndAnswersRandom()
    }

    private fun setPictureAndAnswersRandom(){
        //I get the listSize to create random Values in the correct Range
        //3 random Values, one for each Button
        val listSize: Int = GlobalListHolder.animalList.size
        var rightAnswer: Int = (0 until listSize).random()
        var wrongAnswerOne: Int = (0 until listSize).random()
        var wrongAnswerTwo: Int = (0 until listSize).random()
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

        imgView.setImageDrawable(GlobalListHolder.animalList[rightAnswer].imageResource)

        //Create random Number with a range of three to randomly select which button is
        //going to hold the right Answer
        var randButton: Int = (0 until 3).random()
        when(randButton){
            0 -> {
                butAnsOne.text = GlobalListHolder.animalList[rightAnswer].stringResource
                butAnsTwo.text = GlobalListHolder.animalList[wrongAnswerOne].stringResource
                butAnsThree.text = GlobalListHolder.animalList[wrongAnswerTwo].stringResource

                rightButtonId = R.id.buttonAnswerOne
                }
            1 -> {
                butAnsOne.text = GlobalListHolder.animalList[wrongAnswerOne].stringResource
                butAnsTwo.text = GlobalListHolder.animalList[rightAnswer].stringResource
                butAnsThree.text = GlobalListHolder.animalList[wrongAnswerTwo].stringResource

                rightButtonId = R.id.buttonAnswerTwo
            }
            2 -> {
                butAnsOne.text = GlobalListHolder.animalList[wrongAnswerTwo].stringResource
                butAnsTwo.text = GlobalListHolder.animalList[wrongAnswerOne].stringResource
                butAnsThree.text = GlobalListHolder.animalList[rightAnswer].stringResource

                rightButtonId = R.id.buttonAnswerThree
            }
        }
    }

    //The button to check the answers gets enabled after pressing one of the answer buttons
    fun pressedAnswerButton(view: View){
        pressedButtonId = view.id

        butAnsOne.setBackgroundColor(resources.getColor(R.color.dark_Green))
        butAnsTwo.setBackgroundColor(resources.getColor(R.color.dark_Green))
        butAnsThree.setBackgroundColor(resources.getColor(R.color.dark_Green))

        butPress = findViewById(pressedButtonId)
        butPress.setBackgroundColor(resources.getColor(R.color.light_Green))
        butCheck.isEnabled = true
    }

    //The check button gets disabled for the next Round
    //I stored the id of the right button in the setPictures method
    //I compare it to the pressed Button, and create a toast, then i call the setPicture method again
    fun evaluateAnswer(view: View) {
        butCheck.isEnabled = false
        butPress.setBackgroundColor(resources.getColor(R.color.dark_Green))
        if(pressedButtonId==rightButtonId){
            rightCounter++
            textViewRight.text = "Right answers: " + rightCounter.toString()
            Toast.makeText(this, "Great, you're right", Toast.LENGTH_SHORT).show()
        }
        else {
            var butTempRight: Button = findViewById(rightButtonId)
            wrongCounter++
            textViewWrong.text = "Right answers: " + wrongCounter.toString()
            Toast.makeText(this, "Correct Answer is: " + butTempRight.text, Toast.LENGTH_SHORT).show()
        }

        setPictureAndAnswersRandom()
    }
}