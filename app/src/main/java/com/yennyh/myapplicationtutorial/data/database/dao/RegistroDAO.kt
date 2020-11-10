package com.yennyh.myapplicationtutorial.data.database.dao

import androidx.room.*
import com.yennyh.myapplicationtutorial.data.database.entities.Registro

@Dao  // objeto para encontrar los datos de entities, y acceder a la base de datos
interface RegistroDAO {
    @Insert
    fun insertRegistro(registro: Registro)   //funcion para leer, selecciona de toda la tabla deudor con el nombre indicado

    @Query("SELECT * FROM tabla_registro WHERE email LIKE :email")
    fun searchEmail(email: String): Registro

    @Delete
    fun deleteRegistro(registro: Registro)

    @Update
    fun updateRegistro(registro: Registro)
}