package com.example.gameplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameplanet.Data.productData
import com.example.gameplanet.databinding.ActivityProductBinding
import com.example.gameplanet.databinding.ActivityRegisterBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = productData(this,binding)

        datos.getProducts()

    }
}