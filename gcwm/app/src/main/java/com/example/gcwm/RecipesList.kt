package com.example.gcwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RecipesList : AppCompatActivity() {

    lateinit var returnBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)

        returnBtn = findViewById<Button>(R.id.returnBtn)

        returnBtn.setOnClickListener{

            var intent = Intent(this, AddIngr::class.java)
            startActivity(intent)

        }


    }
}