package com.birdushenin.fieldofdreams

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.HandlerCompat.postDelayed

class MainActivity : AppCompatActivity() {
    private lateinit var rainbowDrumView: RainbowDrumView
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rainbowDrumView = findViewById(R.id.rainbowDrumView)
        resetButton = findViewById(R.id.resetButton)

        val colorNumberTextView = findViewById<TextView>(R.id.colorNumberTextView)

        rainbowDrumView.setOnClickListener {
            if (rainbowDrumView.isSpinning) {
            } else {
                rainbowDrumView.startSpinning()
            }
        }
        rainbowDrumView.setColorNumberTextView(colorNumberTextView)


    }

}