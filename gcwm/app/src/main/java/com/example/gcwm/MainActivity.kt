package com.example.gcwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val intent = Intent(this, AddIngr::class.java)

        when(event?.actionMasked){
            MotionEvent.ACTION_DOWN -> {
                startActivity(intent)
            }
            MotionEvent.ACTION_MOVE -> {
                startActivity(intent)
            }
            MotionEvent.ACTION_UP -> {
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
