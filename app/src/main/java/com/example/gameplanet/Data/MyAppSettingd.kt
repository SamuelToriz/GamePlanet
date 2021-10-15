package com.example.gameplanet.Data

import android.content.Context
import android.content.SharedPreferences

class MyAppSettingd (val context: Context){
    private val PREFS_NAME = "MyConfigurations"
    val sharedPrefe: SharedPreferences =context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
    fun save(keyName:String,value:String){
        val editor = sharedPrefe.edit()
        editor.putString(keyName,value)
        editor.commit()
    }
    fun getValueString(keyName:String):String?{
        return sharedPrefe.getString(keyName,null)
    }
    fun clearData(){
        val editor = sharedPrefe.edit()
        editor.clear()
        editor.commit()
    }
}