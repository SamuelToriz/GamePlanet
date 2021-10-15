package com.example.gameplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gameplanet.Data.UserData
import com.example.gameplanet.Entity.EntityUser
import com.example.gameplanet.Tools.NetworkConnectionState
import com.example.gameplanet.databinding.ActivityCartBinding
import com.example.gameplanet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Login")

        binding.btnOk.setOnClickListener() {

            val x = NetworkConnectionState(this)
            if(x.checkNetwork()){
                logIn()
            }else{
                Toast.makeText(this,"Telefono sin conexión",Toast.LENGTH_LONG).show()
            }

        }
    }
    fun logIn(){
        if(binding.editTextTextEmailAddress.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty())
        {
            val login = UserData(this)
            val user = EntityUser()
            user.email=binding.editTextTextEmailAddress.text.toString()
            user.contraseña=binding.editTextTextPassword.text.toString()
            login.login(user)
        }
    }
}