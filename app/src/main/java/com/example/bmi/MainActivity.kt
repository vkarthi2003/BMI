package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val weight = editTextWeight.text.toString().toDoubleOrNull()
            val height = editTextHeight.text.toString().toDoubleOrNull()

            if (weight != null && height != null) {
                val bmi = calculateBMI(weight, height)
                textViewResult.text = "Your BMI is: $bmi"
            } else {
                textViewResult.text = "Please enter valid weight and height."
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        // BMI formula: weight (kg) / (height (m) * height (m))
        return weight / (height.pow(2))
    }
}
