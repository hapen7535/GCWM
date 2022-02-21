package com.example.gcwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class AddIngr : AppCompatActivity() {


    lateinit var blank : ImageView
    lateinit var ingrs : ImageView
    lateinit var searchBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingr)

        blank = findViewById<ImageView>(R.id.blank)
        ingrs = findViewById<ImageView>(R.id.ingrs)
        searchBtn = findViewById<Button>(R.id.searchBtn)

        searchBtn.setOnClickListener{ //재료 추가를 했을 시에만 작동하도록 예외처리 필요

            var intent = Intent(this, RecipesList::class.java)
            startActivity(intent)

        }


    }
}