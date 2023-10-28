package com.birdushenin.fieldofdreams

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.HandlerCompat.postDelayed
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MainActivity : AppCompatActivity() {
    private lateinit var rainbowDrumView: RainbowDrumView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rainbowDrumView = findViewById(R.id.rainbowDrumView)

        val imageView = findViewById<ImageView>(R.id.imageView2)

        Glide.with(this)
            .load("https://picsum.photos/color")
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)

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