package com.example.hp.kotlin.AlarmApp

import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import com.example.hp.kotlin.R
import kotlinx.android.synthetic.main.pop_time.*

class PopTime:DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.pop_time,container,false)


        var buDone=view.findViewById(R.id.buDone) as Button
        var tp1=view.findViewById(R.id.timePicker) as TimePicker

        buDone.setOnClickListener({
            val ma = activity as AlarmActivity
            if(Build.VERSION.SDK_INT>=23) {
                ma.setTime(tp1.hour, tp1.minute)
            }else{
                ma.setTime(tp1.currentHour, tp1.currentMinute)
            }

            this.dismiss()
        })
        return view
    }




}