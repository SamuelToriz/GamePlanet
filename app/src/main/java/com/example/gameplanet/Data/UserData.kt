package com.example.gameplanet.Data

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gameplanet.Entity.EntityUser
import com.example.gameplanet.ProductActivity
import com.example.gameplanet.Tools.Constants
import org.json.JSONObject

class UserData (val context: Context) {
    private lateinit var queue: RequestQueue

    fun login(user: EntityUser){
        queue= Volley.newRequestQueue(context)
        val url_co= "${Constants.URL}/login"
        val jsonBody = JSONObject()
        jsonBody.put("email",user.email)
        jsonBody.put("password",user.contraseña)


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,url_co,jsonBody,
            { response ->
                Log.d(Constants.TAG,"response is $response")

                val responseMessage:String = response["message"].toString()
                if(responseMessage != "no se econtró el registro"){

                    val preferences = MyAppSettingd(context)
                    preferences.save(Constants.idUser,responseMessage)

                    val i = Intent(context, ProductActivity::class.java)
                    context.startActivity(i)
                }else{
                    Toast.makeText(context,"Usuario o contraseña invalido", Toast.LENGTH_SHORT).show()
                }

            },
            { error ->
                Log.d(Constants.TAG,"error is $error")
                Toast.makeText(context,"$error", Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest)
    }
}