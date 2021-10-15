package com.example.gameplanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.gameplanet.Data.MyAppSettingd
import com.example.gameplanet.Tools.Constants
import com.example.gameplanet.databinding.ActivityCartBinding
import com.example.gameplanet.databinding.ActivitySplashscreenBinding
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val preferences = MyAppSettingd(this)
            try{
                if(preferences.getValueString(Constants.idUser)!!.isNotEmpty()){
                    val intent = Intent(this@SplashScreenActivity, ProductActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            catch (e:Exception){
                val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}