package com.example.gcwm

import android.content.Intent
import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.nex3z.flowlayout.FlowLayout

class RecipeResult : AppCompatActivity() {

    lateinit var homeBtn : Button
    lateinit var returnBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_result)

        homeBtn = findViewById<Button>(R.id.backHome)
        returnBtn = findViewById<Button>(R.id.returnBtn)

        //레시피 결과 추가 부분, 재료에 맞는 레시피가 있을 때만 레시피 결과가 나오도록 예외 처리 필요
        val rootaddSpace = findViewById<LinearLayout>(R.id.resultSpace) //레시피 결과 추가될 공간
        val tagView = layoutInflater.inflate(R.layout.recipe_layout, null, false) //각 레시피 레이아웃
        rootaddSpace.addView(tagView) //레시피 추가

        homeBtn.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        returnBtn.setOnClickListener{

            super.onBackPressed()

        }


    }
}