package com.example.gameplanet.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gameplanet.Entity.EntityProduct
import com.example.gameplanet.R
import com.example.gameplanet.Tools.Constants
import com.example.gameplanet.databinding.ItemProductBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class ProductAdapter (val productList: ArrayList<EntityProduct>, val context: Context) : RecyclerView.Adapter<ProductHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ProductHolder(inflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.textViewProductName.text=productList[position].ProductName
        holder.textViewProductManufac.text=productList[position].ProductManufacturer
        holder.textViewProductPrice.text=productList[position].Cost.toString()
        holder.buttonAgregar.setOnClickListener {
            Toast.makeText(context,"agregar ${productList[position].ProductName}",Toast.LENGTH_LONG).show()
        }
        Picasso.get()
            .load(productList[position].Image)
            .into(holder.imageView3, object : Callback {
                override fun onSuccess() {
                    Log.d(Constants.TAG, "success")
                }

                override fun onError(e: Exception?) {
                    Log.d(Constants.TAG, "error")
                }
            })
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}

class ProductHolder(view: View):RecyclerView.ViewHolder(view)
{
    val binding = ItemProductBinding.bind(view)
    val textViewProductName = binding.textViewProductName
    val textViewProductManufac = binding.textViewProductManufac
    val textViewProductPrice = binding.textViewProductPrice
    val buttonAgregar = binding.buttonAgregar
    val spinnerCantidad = binding.spinnerCantidad
    val imageView3 = binding.imageView3
}