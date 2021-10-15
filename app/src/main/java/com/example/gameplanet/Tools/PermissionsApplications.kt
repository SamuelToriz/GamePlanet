package com.example.gameplanet.Tools

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionsApplications (var context:Context){

    fun hasPermissions (listPermissions:Array<String>):Boolean
    {
        var answer:Boolean= true

        for(permission in listPermissions)
        {
            if(ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
            {
                answer = false
                break
            }
        }
        return answer
    }

    fun acceptPermission(listPermissions: Array<String>, requestCode:Int)
    {
        ActivityCompat.requestPermissions(context as Activity, listPermissions, requestCode)
    }

    fun acceptPermissionInternet(listPermissions: Array<String>, requestCode:Int)
    {
        ActivityCompat.requestPermissions(context as Activity, listPermissions, requestCode)
    }

    fun acceptPermissionStorage(listPermissions: Array<String>, requestCode:Int)
    {
        ActivityCompat.requestPermissions(context as Activity, listPermissions, requestCode)
    }

    fun acceptPermissionNetwork(listPermissions: Array<String>, requestCode:Int)
    {
        ActivityCompat.requestPermissions(context as Activity, listPermissions, requestCode)
    }
}