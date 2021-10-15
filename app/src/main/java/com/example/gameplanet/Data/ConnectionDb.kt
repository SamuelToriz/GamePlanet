package com.example.gameplanet.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.gameplanet.Contracts.SalesContract

class ConnectionDb(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(CREATE_TABLE_SALES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        db?.execSQL(DROP_TABLE_SALES)
        onCreate(db)
    }

    fun openConnection(typeConnection:Int):SQLiteDatabase
    {
        return when(typeConnection)
        {
            MODE_WRITE->{
                writableDatabase
            }
            MODE_READ->{
                readableDatabase
            }
            else -> {
                readableDatabase
            }
        }

    }

    companion object
    {
        const val DATABASE_NAME = "SALES DB"
        const val DATABASE_VERSION = 1
        const val CREATE_TABLE_SALES = "CREATE TABLE ${SalesContract.Entry.TABLE_NAME} " +
                " (${BaseColumns._ID} INTEGER PRIMARY KEY, "+
                "${SalesContract.Entry.COLUMN_NAME_ID_CUSTOMER} INTEGER, " +
                "${SalesContract.Entry.COLUMN_NAME_ID_PRODUCTO} INTEGER, " +
                "${SalesContract.Entry.COLUMN_NAME_NAME_PRODUCTO} VARCHAR(50), " +
                "${SalesContract.Entry.COLUMN_NAME_MANUFACTURE_PRODUCTO} VARCHAR(50), " +
                "${SalesContract.Entry.COLUMN_NAME_CANTIDAD} INTEGER, " +
                "${SalesContract.Entry.COLUMN_NAME_PRECIO} DECIMAL, " +
                "${SalesContract.Entry.COLUMN_NAME_IMAGE} VARCHAR(500))"
        const val DROP_TABLE_SALES="DROP TABLE IF EXISTS ${SalesContract.Entry.TABLE_NAME}"
        const val MODE_WRITE=1
        const val MODE_READ=2
    }
}