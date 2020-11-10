package com.yennyh.myapplicationtutorial

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yennyh.myapplicationtutorial.data.database.DeudorDatabase
import com.yennyh.myapplicationtutorial.data.database.RegistroDatabase

class miregistro : Application() {
    companion object{
        lateinit var database: RegistroDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            RegistroDatabase::class.java,
            "registro_DB"

        ).allowMainThreadQueries()  //quita el bloqueo que pone android por usar bases de datos en la misms vista y no hilo diferente ES TEMPORAL MALA PRACTICA
            .build()
        if (!:: database.isInitialized) {
            onNewsInteractionListener = context
        }
    }
}
