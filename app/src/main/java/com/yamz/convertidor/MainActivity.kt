package com.yamz.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    private var temperatura: String = ""
    private var selectedOption: Int = 0
    private var result: Double = 0.0
    private lateinit var  total : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val option = findViewById<Spinner>(R.id.spinner)
        val temp = findViewById<EditText>(R.id.editTextNumberDecimal)
        total = findViewById(R.id.textView2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            temperatura = temp.text.toString()

            conversion(selectedOption)
        }

        if (option != null) {

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_options)
            )
            option.adapter = adapter

            option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedOption = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }

    private fun conversion(option: Int) {
        when (option) {

            0 -> {

                // °C -> °F     °F = (°C * 9/5) + 32
                result = (temperatura.toDouble() * 9/5) + 32
                total.text = result.toString()
            }
            1 -> {

                // °C -> °K     K = °C + 273.15
                result = temperatura.toDouble() + 273.15
                total.text = result.toString()
            }
            2 -> {

                // °F -> °C     °C = (°F - 32) * 5/9
                result = (temperatura.toDouble() - 32) * 5/9
                total.text = result.toString()
            }
            3 -> {

                // °F -> °K     K = (°F + 459.67) * 5/9
                result = (temperatura.toDouble() + 459.67) * 5/9
                total.text = result.toString()
            }
            4 -> {

                // °K -> °C     °C = K - 273.15
                result = temperatura.toDouble() - 273.15
                total.text = result.toString()
            }
            5 -> {

                // °K -> °F     °F = (K * 9/5) - 459.67
                result = (temperatura.toDouble() * 9/5) - 459.67
                total.text = result.toString()
            }

        }
    }
}