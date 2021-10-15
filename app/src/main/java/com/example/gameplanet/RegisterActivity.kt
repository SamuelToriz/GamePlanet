package com.example.gameplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gameplanet.Tools.Constants
import com.example.gameplanet.databinding.ActivityCartBinding
import com.example.gameplanet.databinding.ActivityRegisterBinding
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var queue : RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Registro de usuario")
        queue = Volley.newRequestQueue(this)

        binding.btnARegistrar.setOnClickListener () {

            val jsonBody = JSONObject()
            jsonBody.put("Name", binding.txtName.text.toString())
            jsonBody.put("LastName", binding.txtLastName.text.toString())
            jsonBody.put("Surname", binding.txtsurname.text.toString())
            jsonBody.put("Gender", binding.spnGender.toString())
            jsonBody.put("DateOfBirth", binding.edtDate.text.toString())
            jsonBody.put("IdMunicipality", binding.spnMunicipality.toString())
            jsonBody.put("Email", binding.edtEmail.text.toString())
            jsonBody.put("Password", binding.edtPassword.text.toString())

            val JsonObjectRequest = JsonObjectRequest(
                Request.Method.POST, Constants.URL, jsonBody,

                Response.Listener { response ->

                    Log.d("UdelP", "Response is:  $response")
                },

                Response.ErrorListener { error ->
                    Log.d("UdelP", "Response is:  $error")
                })

            queue.add(JsonObjectRequest)
        }
        }
    }