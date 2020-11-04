package com.yennyh.myapplicationtutorial.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor

@Dao  // objeto para encontrar los datos de entities, y acceder a la base de datos
interface DeudorDAO {
    @Insert
    fun insertDeudor(deudor: Deudor)   //funcion para leer, selecciona de toda la tabla deudor con el nombre indicado
    @Query("SELECT * FROM tabla_deudor WHERE nombre LIKE :nombre")
    fun searchDeudor(nombre:String):Deudor
    @Delete
    fun deleteDeudor(deudor: Deudor)

}