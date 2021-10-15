package com.example.gameplanet.Entity

data class EntityProduct(
    var Id:Int,
    var ProductName:String,
    var ProductManufacturer:String,
    var Cost:Float,
    var Image:String,
    var Descripction:String
) {
    constructor():this(0,"","",0f,"","")
}
