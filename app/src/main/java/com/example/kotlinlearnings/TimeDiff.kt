package com.example.kotlinlearnings

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class TimeDiff : AppCompatActivity() {
    private lateinit var startTime: Calendar
    private lateinit var endTime: Calendar
    private lateinit var tvTimeDifference: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_diff)

        startTime = Calendar.getInstance()
        endTime = Calendar.getInstance()
        tvTimeDifference = findViewById(R.id.tvTimeDifference)
    }

    fun showStartTimePicker(view: android.view.View) {
        showTimePicker(startTime)
    }

    fun showEndTimePicker(view: android.view.View) {
        showTimePicker(endTime)
    }

    private fun showTimePicker(calendar: Calendar) {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )
        timePickerDialog.show()
    }

    fun calculateTimeDifference(view: android.view.View) {
        if (!this::startTime.isInitialized || !this::endTime.isInitialized) {
            return
        }

        val timeDifferenceInMillis = endTime.timeInMillis - startTime.timeInMillis
        if (timeDifferenceInMillis == 0L){
            Toast.makeText(this, "The time difference is 0", Toast.LENGTH_LONG).show()
        }
        val hours = timeDifferenceInMillis / (1000 * 60 * 60)
        val minutes = (timeDifferenceInMillis % (1000 * 60 * 60)) / (1000 * 60)

        val timeDifferenceText = String.format(
            Locale.getDefault(),
            "Time difference: %02d:%02d",
            hours,
            minutes
        )
        tvTimeDifference.text =  timeDifferenceText
    }
}