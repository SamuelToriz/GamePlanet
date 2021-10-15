package com.example.gameplanet.Entity

data class EntityUser(
    var id:Int,
    var nombre:String,
    var apellido:String,
    var apellidoMaterno:String,
    var genero:String,
    var fechaNacimiento:String,
    var idMunicipio:Int,
    var email:String,
    var contraseña:String,
    var fecha:String
)
{
    constructor():this(0,"", "","","","",0,"","","")
}