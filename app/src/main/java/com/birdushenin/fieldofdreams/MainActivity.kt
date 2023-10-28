package com.birdushenin.fieldofdreams

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MainActivity : AppCompatActivity() {
    private lateinit var rainbowDrumView: RainbowDrumView
    private lateinit var imageView: ImageView
    private lateinit var resetButton: Button
    private lateinit var colorNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rainbowDrumView = findViewById(R.id.rainbowDrumView)
        resetButton = findViewById(R.id.resetButton)
        colorNumber = findViewById(R.id.colorNumberTextView)
        imageView = findViewById(R.id.imageView2)

        Glide.with(this)
            .load("https://th.bing.com/th/id/R.e1885513e5dfcbd47e9ba8ef3ca29d30?rik=MBuuFPFG4uNRKw&pid=ImgRaw&r=0")
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)

        resetButton.setOnClickListener {
            imageView.visibility = View.GONE
            colorNumber.visibility = View.GONE
        }

        rainbowDrumView.setOnClickListener {
            if (rainbowDrumView.isSpinning) {
            } else {
                rainbowDrumView.startSpinning()
            }
        }
        rainbowDrumView.setColorNumberTextView(colorNumber)
        rainbowDrumView.setImage(imageView)
    }
}