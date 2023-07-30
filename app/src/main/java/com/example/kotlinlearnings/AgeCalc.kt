package com.example.kotlinlearnings

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AgeCalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calc)
        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener {
            Toast.makeText(this, "datePicker works", Toast.LENGTH_LONG).show()
            clickDatePicker()
        }

    }
    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val tvSelectedDate: TextView = findViewById(R.id.tvSelectedDate)
        val tvSelectedDateInMinutes: TextView = findViewById(R.id.tvSelectedDateInMinutes)
        val editTextText: EditText = findViewById(R.id.editTextText)
        val displayName: TextView = findViewById(R.id.displayName)
        val inDays: TextView = findViewById(R.id.inDays)
        val inWeeks: TextView = findViewById(R.id.inWeeks)



        val dpd = DatePickerDialog(
            this, { _, selectedYear, selectedMonth, selectedDayOfMonth ->


                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.text = selectedDate
                val name = editTextText.text.toString()
                displayName.text = "Hii, $name You are "
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                theDate?.let {
//                    val selectedDateInMinutes = theDate.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        var different:Long  = currentDate.time - theDate.time ;
                        var forWeek: Long = different
                        var forTotalDays: Long = different
                        val secondsInMilli: Long  = 1000;
                        val minutesInMilli: Long  = secondsInMilli * 60;
                        val hoursInMilli: Long  = minutesInMilli * 60;
                        val daysInMilli: Long = hoursInMilli * 24;
                        val weekInMilli: Long = daysInMilli * 7
                        val monthsInMilli: Long = daysInMilli * 30;

                        val elapsedMonths: Long = different / monthsInMilli;
                        different = different % monthsInMilli
                        val diffMonth: Long = elapsedMonths

                        val elapsedWeeks: Long = forWeek / weekInMilli
                        forWeek = forWeek % weekInMilli
                        val forWeekElapsedDay: Long = forWeek / daysInMilli

                        val elapsedDays: Long = different / daysInMilli;
                        different = different % daysInMilli;
                        val diffDays: Long = elapsedDays;

                        val totalDays: Long = forTotalDays / daysInMilli

                        tvSelectedDateInMinutes.text = "$diffMonth Months And $diffDays Days or"
                        inWeeks.text = "$elapsedWeeks week and $forWeekElapsedDay days Old"
                        inDays.text = "$totalDays days or"
                    }
                }

            },
            year, month, day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }

}