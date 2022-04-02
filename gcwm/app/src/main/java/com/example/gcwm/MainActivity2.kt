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
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var returnBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        returnBtn = findViewById<Button>(R.id.returnBtn)

        //레시피 결과 추가 부분, 재료에 맞는 레시피가 있을 때만 레시피 결과가 나오도록 예외 처리 필요
        /* if(intent.hasExtra("ingr")){ //재료가 전달되었으면 레시피 레이아웃을 추가 재료 전달된 것을 레시피명으로 바꿔서 추가해야함 수정 필요
             val tagView = layoutInflater.inflate(R.layout.recipe_layout, null, false) //각 레시피 레이아웃
             rootaddSpace.addView(tagView) //레시피 추가
         }*/

        val container = findViewById<LinearLayout>(R.id.recipeList) //레시피 결과 추가될 공간

        val tagView = layoutInflater.inflate(R.layout.recipe_layout, null, false) //각 레시피 레이아웃
        val tagViewText = tagView.findViewById<TextView>(R.id.tagText) //동적 레이아웃의 텍스트 재료명이 들어감
        val title = findViewById<TextView>(R.id.listTitle)

        tagViewText!!.setText("코울슬로") //tagViewText가 null이 아님을 알림

            container.addView(tagView) //레시피 추가

        tagView.setOnClickListener{
            val intent = Intent(this, RecipeResult::class.java)
            startActivity(intent)
        }

        returnBtn.setOnClickListener{

            super.onBackPressed()

        }


    }

}