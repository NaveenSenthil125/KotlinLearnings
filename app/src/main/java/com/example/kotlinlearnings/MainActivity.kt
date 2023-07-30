package com.example.kotlinlearnings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAgeCalc: Button = findViewById(R.id.btnAgeCalc)
        val btnTimeDiff: Button = findViewById(R.id.btnTimeDiff)
        btnAgeCalc.setOnClickListener{
            val openAgeCalc = Intent(this, AgeCalc::class.java)
            startActivity(openAgeCalc)
        }
        btnTimeDiff.setOnClickListener {
            val openTimeDiff = Intent(this, TimeDiff::class.java)
            startActivity(openTimeDiff)
        }
    }

}