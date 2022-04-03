package com.example.gcwm

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var MainText : TextView

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val intent = Intent(this, AddIngr::class.java)
        MainText = findViewById<TextView>(R.id.mainText)
        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 50
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE

        when(event?.actionMasked){
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                MainText.startAnimation(anim)
                startActivity(intent)
            }
        }


        return super.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }

    }


