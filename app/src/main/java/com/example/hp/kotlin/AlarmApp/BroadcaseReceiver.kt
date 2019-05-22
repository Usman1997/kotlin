package com.example.hp.kotlin.AlarmApp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcaseReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action.equals("com.tester.alarmmanager")){
            var b=intent.extras
            // Toast.makeText(context,b.getString("message"),Toast.LENGTH_LONG).show()
            val notifyMe=Notifications()
            notifyMe.Notify(context!!,b.getString("message"),10)
        }
        else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){

            val saveData=SaveData(context!!)
            saveData.setAlarm()
        }
    }

}