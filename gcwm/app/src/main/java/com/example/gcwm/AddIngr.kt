package com.example.gcwm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.widget.AdapterView

import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.inflate
import com.nex3z.flowlayout.FlowLayout


class AddIngr : AppCompatActivity() {


    lateinit var blank : ImageView
    lateinit var ingrs : ImageView
    lateinit var searchBtn : Button
    lateinit var searchBar : AutoCompleteTextView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingr)

        val tagArrayList = ArrayList<String>() //가변 크기의 태그 배열

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

        val rootaddSpace = findViewById<FlowLayout>(R.id.addSpace)
        val deleteTag = findViewById<Button>(R.id.deleteMark)
        val parentWidth = rootaddSpace.width //부모 View의 가로 길이를 구한다 (View 개행을 돕기 위함)

        searchBar.setAdapter(adapter)

        searchBar.threshold = 1 //1개 이상의 글자가 겹쳐졌을 때 검색

        searchBar.setOnItemClickListener{ parent, view, position, id ->

            //실제 position
            val selection = parent.getItemAtPosition(position) //autoCompleteTextView 내 선택된 것
            var pos = -1

            for (i in 0 until ingrNames.size) {
                if (ingrNames.get(i).equals(selection)) {
                    pos = i
                    break
                }
            }

            tagArrayList.add(ingrNames[pos]) //태그 array에 추가

            val tagView = layoutInflater.inflate(R.layout.tag_layout, null, false)
            val tagViewText = tagView.findViewById<TextView>(R.id.tagText) //동적 레이아웃의 텍스트 재료명이 들어감

            val searchToast = Toast.makeText(applicationContext,"${tagArrayList.size}",Toast.LENGTH_SHORT) //검색한 재료의 동적 뷰가 추가되도록 수정 필요
            searchToast.show()

            tagViewText.setText(ingrNames[pos])


            rootaddSpace.addView(tagView) //태그 추가


        }



        searchBtn.setOnClickListener{ //재료 추가를 했을 시에만 작동하도록 예외처리 필요

            var intent = Intent(this, RecipesList::class.java)
            startActivity(intent)

        }


    }
}