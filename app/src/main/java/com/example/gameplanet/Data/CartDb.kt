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
        db=conectionDb.openConnection(ConnectionDb.MODE_WRITE)
        val values = ContentValues().apply {
            put(SalesContract.Entry.COLUMN_NAME_ID_PRODUCTO,sales.idProduct)
            put(SalesContract.Entry.COLUMN_NAME_NAME_PRODUCTO,sales.nameProduct)
            put(SalesContract.Entry.COLUMN_NAME_MANUFACTURE_PRODUCTO,sales.manufactureProduct)
            put(SalesContract.Entry.COLUMN_NAME_CANTIDAD,sales.numberProducts)
            put(SalesContract.Entry.COLUMN_NAME_PRECIO,sales.costo)
            put(SalesContract.Entry.COLUMN_NAME_IMAGE,sales.image)
        }
        return db.insert(SalesContract.Entry.TABLE_NAME,null,values)
    }
    fun delete(id:Int):Int{
        db=conectionDb.openConnection(ConnectionDb.MODE_WRITE)
        val where = "${BaseColumns._ID} =?"
        val arg = arrayOf(id.toString())
        return db.delete(SalesContract.Entry.TABLE_NAME,where,arg)
    }
    fun getOne(id:Int){
        db=conectionDb.openConnection(ConnectionDb.MODE_READ)
        val projection = arrayOf(BaseColumns._ID,
            SalesContract.Entry.COLUMN_NAME_ID_CUSTOMER,
            SalesContract.Entry.COLUMN_NAME_ID_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_NAME_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_MANUFACTURE_PRODUCTO,
            SalesContract.Entry.COLUMN_NAME_CANTIDAD,
            SalesContract.Entry.COLUMN_NAME_PRECIO,
            SalesContract.Entry.COLUMN_NAME_IMAGE)
        val where = "${BaseColumns._ID} =?"
        val arg = arrayOf(id.toString())
        val cursor=db.query(SalesContract.Entry.TABLE_NAME,projection,where,arg,null,null,null)
        if(cursor.moveToFirst()){
            val id:Long=cursor.getLong(0)
            val name=cursor.getString(1)
            val lastName=cursor.getString(2)
            val gender=cursor.getInt(3)
            val date=cursor.getString(4)
            Log.d(Constants.TAG,"$id | $name | $lastName | $gender | $date" )
        }
        else
        {
            Log.d(Constants.TAG,"Sin valores")
        }
    }
}
