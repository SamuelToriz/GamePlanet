package com.example.gameplanet.Data

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.gameplanet.Adapters.ProductAdapter
import com.example.gameplanet.Entity.EntityProduct
import com.example.gameplanet.Tools.Constants
import com.example.gameplanet.databinding.ActivityProductBinding
import org.json.JSONObject

class productData(val context: Context, val binding:ActivityProductBinding) {
    private lateinit var queue: RequestQueue

    fun getProducts(){
        queue= Volley.newRequestQueue(context)
        val url_co= "${Constants.URL}/product"
        Log.d(Constants.TAG, "$url_co")
        Toast.makeText(context, "$url_co",Toast.LENGTH_LONG).show()
        val list = ArrayList<EntityProduct>()
        val stringRequest = StringRequest(
            Request.Method.GET,url_co,
            { response ->
                Log.d(Constants.TAG, "response is $response")
                val jsonObject = JSONObject(response)
                val detalleArray = jsonObject.getJSONArray("products")
                for (i in 0 until detalleArray.length()){
                    val product = EntityProduct()
                    product.Id=detalleArray.getJSONObject(i).getInt("id")
                    product.ProductName=detalleArray.getJSONObject(i).getString("productName")
                    product.ProductManufacturer=detalleArray.getJSONObject(i).getString("productManufacturer")
                    product.Cost=detalleArray.getJSONObject(i).getDouble("cost").toFloat()
                    product.Descripction=detalleArray.getJSONObject(i).getString("description")
                    product.Image=detalleArray.getJSONObject(i).getString("image")
                    list.add(product)
                }
                loadRecycler(list)
            },
            { error ->
                Log.d(Constants.TAG, "error is $error")
                Toast.makeText(context, "error is $error",Toast.LENGTH_LONG).show()
            }
        )
        queue.add(stringRequest)
    }

    private fun loadRecycler(list:ArrayList<EntityProduct>){
        val adapter = ProductAdapter(list,context)
        val linearLayout = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.rvwProdcuts.layoutManager=linearLayout
        binding.rvwProdcuts.setHasFixedSize(true)
        binding.rvwProdcuts.adapter=adapter
    }
}