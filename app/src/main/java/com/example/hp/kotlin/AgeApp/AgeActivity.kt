package com.example.hp.kotlin.AgeApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.activity_age.*
import java.util.*


class AgeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age);
    }

    fun calculateEvent(view:View){
        val birthYear:String = birthYear.text.toString()
        var year:Int  = Calendar.getInstance().get(Calendar.YEAR)
        val myAge = year - birthYear.toInt()
        age.setText("Your age is "+myAge);
    }
}