package com.example.gameplanet.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import android.util.Log
import com.example.gameplanet.Contracts.SalesContract
import com.example.gameplanet.Entity.EntitySales
import com.example.gameplanet.Entity.EntitySalesDetail
import com.example.gameplanet.Tools.Constants

class CartDb (val context: Context){

    val conectionDb=ConnectionDb(context)
    private lateinit var db:SQLiteDatabase

    fun add(sales: EntitySalesDetail):Long
    {
        val customer = MyAppSettingd(context).getValueString(Constants.idUser)
        db=conectionDb.openConnection(ConnectionDb.MODE_WRITE)
        val values = ContentValues().apply {
            put(SalesContract.Entry.COLUMN_NAME_ID_CUSTOMER,customer)
            put(SalesContract.Entry.COLUMN_NAME_ID_PRODUCTO,sales.idProduct)
            put(SalesContract.Entry.COLUMN_NAME_NAME_PRODUCTO,sales.nameProduct)
            put(SalesContract.Entry.COLUMN_NAME_MANUFACTURE_PRODUCTO,sales.manufactureProduct)
            put(SalesContract.Entry.COLUMN_NAME_CANTIDAD,sales.numberProducts)
            put(SalesContract.Entry.COLUMN_NAME_PRECIO,sales.costo)
            put(SalesContract.Entry.COLUMN_NAME_IMAGE,sales.image)
        }
        Log.d(Constants.TAG,"se insertó")
        return db.insert(SalesContract.Entry.TABLE_NAME,null,values)
    }
    fun delete(id:Int):Int{
        db=conectionDb.openConnection(ConnectionDb.MODE_WRITE)
        val where = "${BaseColumns._ID} =?"
        val arg = arrayOf(id.toString())
        return db.delete(SalesContract.Entry.TABLE_NAME,where,arg)
    }
    fun getOne(idCustomer:Int):ArrayList<EntitySalesDetail>{
        var carrito = ArrayList<EntitySalesDetail>()
        db=conectionDb.openConnection(ConnectionDb.MODE_READ)

        val projection = arrayOf(BaseColumns._ID,
            SalesContract.Entry.COLUMN_NAME_ID_CUSTOMER,
            SalesContract.Entry.COLUMN_NAME_ID_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_NAME_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_MANUFACTURE_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_CANTIDAD,
            SalesContract.Entry.COLUMN_NAME_PRECIO,
            SalesContract.Entry.COLUMN_NAME_IMAGE)
        val where = "${SalesContract.Entry.COLUMN_NAME_ID_CUSTOMER} =?"
        val arg = arrayOf(idCustomer.toString())
        val cursor=db.query(SalesContract.Entry.TABLE_NAME,projection,where,arg,null,null,null)

        if(cursor.moveToFirst()){
            do{
                val carritoPos=EntitySalesDetail()
                carritoPos.id=cursor.getInt(0)
                carritoPos.idProduct=cursor.getInt(1)
                carritoPos.nameProduct=cursor.getString(2)
                carritoPos.manufactureProduct=cursor.getString(3)
                carritoPos.numberProducts=cursor.getInt(4)
                carritoPos.costo=cursor.getFloat(5)
                carritoPos.image=cursor.getString(6)
                carrito.add(carritoPos)

                Log.d(Constants.TAG,"" )
            }while (cursor.moveToNext())

        }
        else
        {
            Log.d(Constants.TAG,"Sin valores")
        }
        return carrito
    }
}
