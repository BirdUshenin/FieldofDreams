package com.birdushenin.fieldofdreams

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import java.util.*

class RainbowDrumView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val colors = intArrayOf(
        Color.RED, Color.parseColor("#FFA500"), Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.parseColor("#4B0082")
    )

    private var colorNumberTextView: TextView? = null
    fun setColorNumberTextView(textView: TextView) {
        colorNumberTextView = textView
    }
    @SuppressLint("SetTextI18n")
    private fun updateColorNumberTextView() {
//        colorNumberTextView?.text = "Color Number: $colorNumber"
        when (colorNumber) {
            0 -> colorNumberTextView?.text = "Красный"
            1 -> colorNumberTextView?.text = "Оранжевый"
            2 -> colorNumberTextView?.text = "Желтый"
            3 -> colorNumberTextView?.text = "Зеленый"
            4 -> colorNumberTextView?.text = "Голубой"
            5 -> colorNumberTextView?.text = "Синий"
            6 -> colorNumberTextView?.text = "Фиолетовый"
        }
    }
    private val paint = Paint()
    private var currentRotation = 0f
    var isSpinning = false

    init {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val centerX = width / 2
        val centerY = height / 2
        val radius = width / 2

        for (i in colors.indices) {
            paint.color = colors[i]
            canvas?.drawArc(0f, 0f, width, height, i * 360f / 7 + currentRotation, 360f / 7, true, paint)
        }

        if (isSpinning) {
            invalidate()
        }
    }

    private val spinAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f).apply {
        duration = 2000
        repeatCount = ObjectAnimator.INFINITE
        interpolator = LinearInterpolator()
    }
    private var colorNumber = 0

    fun startSpinning() {
        if (!spinAnimator.isRunning) {
            isSpinning = true
            spinAnimator.start()
            postDelayed({
                stopSpinning()
            }, (2000..6000).random().toLong())
        }
    }

    private fun stopSpinning() {
        if (spinAnimator.isRunning) {
            isSpinning = false
            spinAnimator.cancel()
            colorNumber = this.rotation.toInt()
            while (colorNumber >360) {colorNumber -= 360}
            colorNumber /= (360/7)
            colorNumber = 6 - colorNumber
            updateColorNumberTextView()
        }
    }
}