package com.yennyh.myapplicationtutorial.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_deudor")  //datos en la tabla para almacenar
data class Deudor(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String? = null,
    @ColumnInfo(name = "telefono")val telefono:Long? = null,
    @ColumnInfo(name = "valor")val valor: Long? = null//data permite acceder a cada uno de ellos, contructor
)