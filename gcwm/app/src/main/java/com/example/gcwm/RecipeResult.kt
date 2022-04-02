package com.example.gcwm

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class RecipeResult : AppCompatActivity() {

    lateinit var homeBtn : Button
    lateinit var returnBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_result)

        homeBtn = findViewById<Button>(R.id.backHome)
        returnBtn = findViewById<Button>(R.id.returnBtn)


        homeBtn.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        returnBtn.setOnClickListener{

            super.onBackPressed()

        }


    }
}