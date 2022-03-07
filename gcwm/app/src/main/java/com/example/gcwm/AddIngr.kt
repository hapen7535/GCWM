package com.example.gcwm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class AddIngr : AppCompatActivity() {


    lateinit var blank : ImageView
    lateinit var ingrs : ImageView
    lateinit var searchBtn : Button
    lateinit var searchBar : AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingr)

        blank = findViewById<ImageView>(R.id.blank)
        ingrs = findViewById<ImageView>(R.id.ingrs)
        searchBtn = findViewById<Button>(R.id.searchBtn)
        searchBar = findViewById<AutoCompleteTextView>(R.id.searchIngr)

        val ingrNames = arrayOf( //테스트용으로 적어놓음 나중에 DB에서 불러와야함
            "양배추",
            "상추",
            "식빵",
            "계란"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, //목록이 출력될 모양 설정
            ingrNames
        )

        searchBar.setAdapter(adapter)

        searchBar.threshold = 1 //1개 이상의 글자가 겹쳐졌을 때 검색

        searchBar.setOnItemClickListener{ parent, view, position, id ->

            //실제 position
     /*       val selected = parent.getItemAtPosition(position)
            var pos = Arrays.asList(ingrNames).indexOf(selected)*/

            val selection = parent.getItemAtPosition(position)
            var pos = -1

            for (i in 0 until ingrNames.size) {
                if (ingrNames.get(i).equals(selection)) {
                    pos = i
                    break
                }
            }

            val searchToast = Toast.makeText(applicationContext,"${ingrNames[pos]}",Toast.LENGTH_SHORT) //검색한 재료의 동적 뷰가 추가되도록 수정 필요
            searchToast.show()

            //재료 클릭했을 때 동적 레이아웃 추가
            val rootaddSpace = findViewById<LinearLayout>(R.id.addSpace) //root LinearLayout
            val tagView = layoutInflater.inflate(R.layout.tag_layout, rootaddSpace, false) //동적으로 추가할 레이아웃
            val tagViewText = tagView.findViewById<TextView>(R.id.tagText) //동적 레이아웃의 텍스트 재료명이 들어감
            tagViewText.setText(ingrNames[position])

            //태그 패딩 추가
            val dm = resources.displayMetrics
            val size = Math.round(20 * dm.density)
            tagView.setPadding(size,size,size,size)

            rootaddSpace.addView(tagView) //태그 추가

        }

        searchBtn.setOnClickListener{ //재료 추가를 했을 시에만 작동하도록 예외처리 필요

            var intent = Intent(this, RecipesList::class.java)
            startActivity(intent)

        }


    }
}