package com.example.kotlinlearnings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Layouts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)
        actionBar?.show()
    }
}