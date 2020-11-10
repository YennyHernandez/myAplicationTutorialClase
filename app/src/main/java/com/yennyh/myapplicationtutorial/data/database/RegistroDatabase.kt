package com.yennyh.myapplicationtutorial.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yennyh.myapplicationtutorial.data.database.dao.DeudorDAO
import com.yennyh.myapplicationtutorial.data.database.dao.RegistroDAO
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor
import com.yennyh.myapplicationtutorial.data.database.entities.Registro

@Database(entities = [Registro ::class], version = 1)
abstract class RegistroDatabase: RoomDatabase(){
    abstract fun RegistroDAO(): RegistroDAO
}