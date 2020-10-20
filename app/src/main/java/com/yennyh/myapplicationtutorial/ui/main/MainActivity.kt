package com.yennyh.myapplicationtutorial.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.buscar.BuscarFragment
import com.yennyh.myapplicationtutorial.ui.crear.CrearFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        //por defecto se agrega fragmento crear
        val crearFragment = CrearFragment()
        transaction.add(R.id.contenedor, crearFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val manager = supportFragmentManager  //se puede poner private var afuera pero en cada override se debe poner transactio = manager.begintransation porque el con commit solo lo hace una vez por transation
        val transaction = manager.beginTransaction()
        when(item.itemId){
            R.id.menu_crear->{
                val crearFragment = CrearFragment()
                transaction.replace(R.id.contenedor, crearFragment).commit()
            }
            R.id.menu_buscar->{
                val BuscarFragment =BuscarFragment()
                transaction.replace(R.id.contenedor, BuscarFragment).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}