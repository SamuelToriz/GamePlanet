package com.example.gameplanet.Entity

import java.util.*

data class EntitySales(
    var id:Int,
    var idCustomer:Int,
    var date:String,
    var status:Int,
    var listDetail:ArrayList<EntitySalesDetail>

)

{
        constructor():this(0,0, "",0, arrayListOf(EntitySalesDetail()))
}

data class EntitySalesDetail(
    var id:Int,
    var idOnlineSales:Int,
    var idProduct:Int,
    var nameProduct:String,
    var manufactureProduct:String,
    var numberProducts:Int,
    var costo:Float,
    var image:String,
)
{
    constructor():this(0,0,0,"","",0,0F,"")
}