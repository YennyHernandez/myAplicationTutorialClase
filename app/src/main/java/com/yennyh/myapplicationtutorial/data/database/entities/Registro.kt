package com.yennyh.myapplicationtutorial.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_registro")  //datos en la tabla para almacenar
data class Registro(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
   // @ColumnInfo(name = "telefono")val telefono:Long? = null,
    @ColumnInfo(name = "contrasena")val contrasena: String? = null //data permite acceder a cada uno de ellos, contructor
)