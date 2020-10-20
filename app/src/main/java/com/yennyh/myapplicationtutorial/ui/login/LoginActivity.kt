package com.yennyh.myapplicationtutorial.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.main.MainActivity
import com.yennyh.myapplicationtutorial.ui.registro.RegistroActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var correctEmail: String = ""
    private var correctPassword: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputDataUser = intent.extras
        correctEmail = inputDataUser?.getString("correo").toString()
        correctPassword = inputDataUser?.getString("contrasena").toString()


        contrasena_editTextText.setText(if(correctPassword!="null") correctPassword else "")
        nombre_editTextText.setText(if(correctEmail!="null") correctEmail else "")

        registrar_login_button.setOnClickListener{
            val intent = Intent ( this, RegistroActivity::class.java) //configuro para donde voy
            startActivity(intent) //lo ejecuta
            finish()
        }

        ingresar_button.setOnClickListener {
            val intent = Intent ( this, MainActivity::class.java) //configuro para donde voy
            startActivity(intent) //lo ejecuta
            finish()
        }

    }

}