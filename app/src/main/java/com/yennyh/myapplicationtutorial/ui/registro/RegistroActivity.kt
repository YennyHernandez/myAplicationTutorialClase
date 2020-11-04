package com.yennyh.myapplicationtutorial.ui.registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*


class RegistroActivity : AppCompatActivity() {

    companion object{
        private const val EMPTY =""
        private const val SPACE =" "
    }
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Log.d( "Metodo","onCreate")
        registrar_button.setOnClickListener{


            val nombre = nombre_edit_text.text.toString()
            val correo = correo_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val verificarcontra = verificarcontra_edit_text.text.toString()
            val genero = if (masculino_radio_button.isChecked) getString(R.string.masculino) else getString(
                R.string.femenino
            )

            var pasatiempo =
                EMPTY
            if (nadar_checkBox.isChecked) pasatiempo += getString(R.string.nadar) + SPACE
            if (caminar_checkbox.isChecked) pasatiempo += getString(R.string.Caminar) + SPACE
            if(leer_checkbox.isChecked) pasatiempo += getString(R.string.leer)

            val ciudaddenacimiento = ciudad_nacimiento_spinner.selectedItem
            respuesta_text_View.text = getString(R.string.respuesta, nombre, correo, telefono, contrasena, verificarcontra, genero, pasatiempo, ciudaddenacimiento)

            /* ------------  se puede crear funcion para enviar datos-------- */
                val login = Intent(this, LoginActivity::class.java)
                login.putExtra("correo", correo)
                login.putExtra("contrasena", contrasena)
                startActivity(login)
                finish()
            /* -------------------------------------------------------------- */

        }

     }



    override fun onStart() {
        super.onStart()
        Log.d( "Metodo","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d( "Metodo","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d( "Metodo","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d( "Metodo","onStop")
    }
    override fun onBackPressed() {
        val login = Intent(this, LoginActivity::class.java)
        startActivity(login)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( "Metodo","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( "Metodo","onRestart")
    }

}