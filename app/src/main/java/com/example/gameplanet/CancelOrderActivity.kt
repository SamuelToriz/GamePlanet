package com.example.gameplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gameplanet.Tools.Constants
import com.example.gameplanet.databinding.ActivityCancelOrderBinding
import com.example.gameplanet.databinding.ActivityCartBinding
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject

class CancelOrderActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCancelOrderBinding
    private lateinit var queue : RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCancelOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Cancelar Compra")
        queue = Volley.newRequestQueue(this)

        binding.btnCancerlar.setOnClickListener {
            if(binding.edtEmailCancel.text.isNotEmpty() && binding.edtIdCancel.text.isNotEmpty() && binding.edtPasswordCancel.text.isNotEmpty())
            {

                val jsonBody = JSONObject()
                jsonBody.put("id", binding.edtIdCancel)
                jsonBody.put("email", binding.edtEmailCancel)
                jsonBody.put("password", binding.edtPasswordCancel)

                val JsonObjectRequest = JsonObjectRequest(
                    Request.Method.PUT, Constants.URL, jsonBody,

                    Response.Listener { response ->

                        Log.d("UdelP", "Response is:  $response")
                    },

                    Response.ErrorListener { error ->
                        Log.d("UdelP", "Response is:  $error")
                    })

                queue.add(JsonObjectRequest)
            }
            else
            {
                Snackbar.make(it, "NO TIENE DATOS DE CANCELACION", Snackbar.LENGTH_LONG).show()
            }
        }


        }
    }
