package com.example.kotlinlearnings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class QuizApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_app)
        val editText1: EditText = findViewById(R.id.editText1)
        val startBtn: Button = findViewById(R.id.startBtn)
        startBtn.setOnClickListener {
            if (editText1.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val quizQuestions = Intent(this , QuizQuestions::class.java)
                startActivity(quizQuestions)
            }
        }
    }
}