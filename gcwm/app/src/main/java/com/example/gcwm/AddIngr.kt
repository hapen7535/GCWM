package com.example.gcwm

import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.widget.AdapterView

import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.inflate
import androidx.core.view.LayoutInflaterCompat
import com.example.gcwm.databinding.ActivityAddIngrBinding
import com.nex3z.flowlayout.FlowLayout
import kotlin.collections.ArrayList


class AddIngr : AppCompatActivity() {

    lateinit var binding : ActivityAddIngrBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingr)

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

        val tagArray = ArrayList<String>() //태그 삭제를 위한 배열


        binding.searchIngr.setAdapter(adapter)

        binding.searchIngr.threshold = 1 //1개 이상의 글자가 겹쳐졌을 때 검색

        binding.searchIngr.setOnItemClickListener{ parent, view, position, id -> //내부 코드는 함수형으로 바꿀 것

            //실제 position
            val selection = parent.getItemAtPosition(position) //autoCompleteTextView 내 선택된 것
            var pos = -1

            for (i in 0 until ingrNames.size) {
                if (ingrNames.get(i).equals(selection)) {
                    pos = i
                    break
                }
            }



            val tagView = layoutInflater.inflate(R.layout.tag_layout, null, false)
            val tagViewText = tagView.findViewById<TextView>(R.id.tagText) //동적 레이아웃의 텍스트 재료명이 들어감

            tagViewText!!.setText(ingrNames[pos]) //tagViewText가 null이 아님을 알림

            binding.addSpace.addView(tagView) //태그 추가
            tagArray.add(ingrNames[pos].toString())

            tagView?.setOnClickListener{

                tagArray.remove(ingrNames[pos])
                binding.addSpace.removeView(tagView)

            }



        }



        binding.searchBtn.setOnClickListener{ //재료 추가를 했을 시에만 작동하도록 예외처리 필요

            var intent = Intent(this, RecipesList::class.java)
            if(!tagArray.isEmpty()){
                intent.putExtra("ingr", tagArray) //재료명이 담긴 배열을 다음 액티비티에 전송
            }
            startActivity(intent)

        }


    }

}