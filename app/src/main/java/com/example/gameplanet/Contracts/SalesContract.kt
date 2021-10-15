package com.example.gameplanet.Contracts

import android.provider.BaseColumns

object SalesContract {

    object Entry: BaseColumns
    {
        const val TABLE_NAME = "CTL_ONLINE_CART"
        const val  COLUMN_NAME_ID_CUSTOMER ="idCustomer"
        const val  COLUMN_NAME_ID_PRODUCTO ="idProduct"
        const val  COLUMN_NAME_NAME_PRODUCTO ="NameProduct"
        const val  COLUMN_NAME_MANUFACTURE_PRODUCTO ="ManufactureProduct"
        const val  COLUMN_NAME_CANTIDAD ="cantidad"
        const val  COLUMN_NAME_PRECIO ="precio"
        const val  COLUMN_NAME_IMAGE ="imagen"
    }

}