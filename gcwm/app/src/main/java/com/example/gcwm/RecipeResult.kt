package com.example.gcwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RecipeResult : AppCompatActivity() {

    lateinit var homeBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_result)

        homeBtn = findViewById<Button>(R.id.backHome)

        homeBtn.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}