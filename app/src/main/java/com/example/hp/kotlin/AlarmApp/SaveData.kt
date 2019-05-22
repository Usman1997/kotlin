package com.example.hp.kotlin.AlarmApp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import java.util.*
import kotlin.math.min

class SaveData {

    var context:Context?=null
    var sharedPreferences:SharedPreferences?=null

    constructor(context: Context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("myRef",Context.MODE_PRIVATE)
    }


    fun saveData(hour:Int,minute:Int){
        var editor = sharedPreferences!!.edit()
        editor.putInt("hour",hour)
        editor.putInt("minute",minute)
        editor.commit()
    }

    fun getHour():Int{
        return sharedPreferences!!.getInt("hour",0)
    }

    fun getMinutes():Int{
        return sharedPreferences!!.getInt("minute",0)
    }

    fun setAlarm(){
        val hour = getHour()
        val minute = getMinutes()
        val calender = Calendar.getInstance()
        calender.set(Calendar.HOUR_OF_DAY,hour)
        calender.set(Calendar.MINUTE, minute)
        calender.set(Calendar.SECOND,0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        var intent = Intent(context, BroadcaseReceiver::class.java)
        intent.putExtra("message", " alarm time")
        intent.action = "com.tester.alarmmanager"
        val pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


        am.setRepeating(AlarmManager.RTC_WAKEUP, calender.timeInMillis,
                AlarmManager.INTERVAL_DAY, pi)
    }
}