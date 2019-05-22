package com.example.hp.kotlin.AlarmApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.activity_alarm.*
import kotlin.math.min

class AlarmActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        val saveData=SaveData(applicationContext)

        tvShowTime.text= saveData.getHour().toString() + ":" + saveData.getMinutes().toString()
    }


    fun BuSetTime(view:View){
        val popTime= PopTime()
        val fm= supportFragmentManager
        popTime.show(fm,"Select time")
    }

    fun setTime(hours:Int,minutes:Int){
        tvShowTime.text = hours.toString()+ ":"+ minutes.toString()
        val saveData=SaveData(applicationContext)
        saveData.saveData(hours, minutes)
        saveData.setAlarm()

    }
}