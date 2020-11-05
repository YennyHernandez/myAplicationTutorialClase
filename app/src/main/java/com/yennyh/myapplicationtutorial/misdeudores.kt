package com.yennyh.myapplicationtutorial

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yennyh.myapplicationtutorial.data.database.DeudorDatabase

class misdeudores : Application() {
    companion object{
        lateinit var database: DeudorDatabase
}
 //archivo principal de la aplicacion para base de datos
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
            /*deudor_DB, nombre de la base de datos que tiene una tabla_deudor(deudor.kt) con 4 campos
        en deudorDAO hay una funcion que inserta los datos del formulario*/
        ).allowMainThreadQueries()  //quita el bloqueo que pone android por usar bases de datos en la misms vista y no hilo diferente ES TEMPORAL MALA PRACTICA
            .build()
    }
}

