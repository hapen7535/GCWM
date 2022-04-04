package com.example.gcwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.gcwm.databinding.ActivityRecipeResultBinding
import java.util.zip.Inflater


class RecipeResult : AppCompatActivity() {

    lateinit var binding : ActivityRecipeResultBinding
    lateinit var homeBtn : Button
    lateinit var returnBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_result)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_recipe_result)

        binding.backHome.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        binding.returnBtn.setOnClickListener{

            super.onBackPressed()

        }


    }
}