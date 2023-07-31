package com.example.kotlinlearnings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val btnAgeCalc: Button
        val btnTimeDiff: Button
        val btnCalculator: Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAgeCalc = findViewById(R.id.btnAgeCalc)
        btnTimeDiff = findViewById(R.id.btnTimeDiff)
        btnCalculator = findViewById(R.id.btnCalculator)

        btnAgeCalc.setOnClickListener{
            val openAgeCalc = Intent(this, AgeCalc::class.java)
            startActivity(openAgeCalc)
        }
        btnTimeDiff.setOnClickListener {
            val openTimeDiff = Intent(this, TimeDiff::class.java)
            startActivity(openTimeDiff)
        }
        btnCalculator.setOnClickListener {
            val openCalculator = Intent(this, Calculator::class.java)
            startActivity(openCalculator)
        }
    }

}