package com.example.kotlinlearnings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestions : AppCompatActivity() {
    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val questionslist = Constants.getQuestions()
        Log.e("Questions Size", "${questionslist.size}")
        for (i in questionslist) {
            Log.e("Questions", i.question)
        }
        val currentPosition = 0 // Default and the first question position
        val question: Question? =
            questionslist[currentPosition]
        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        progressBar?.progress = currentPosition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text = "$currentPosition" + "/" + progressBar?.getMax() // Setting up the progress text

        // Now set the current question and the options in the UI
        tvQuestion?.text = question!!.question
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }
}