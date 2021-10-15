package com.example.gameplanet.Entity

data class EntityMunicipio(
 var id:Int,
 var idEstado:Int,
 var nombreMunicipio:String,
 var isMetropolitanArea:Boolean
 )
{
    constructor():this(0,0,"",false)
}