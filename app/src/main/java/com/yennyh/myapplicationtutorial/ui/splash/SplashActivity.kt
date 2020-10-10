package com.yennyh.myapplicationtutorial.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.login.LoginActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val timer = Timer()   // lo que quiero ejecutar
        timer.schedule(timerTask {
            gotoLoginActivity()
        },  2000 // cuanto tiempo lo voy a ejecutar
        )

    }

    fun gotoLoginActivity(){
        val intent = Intent ( this, LoginActivity::class.java) //configuro para donde voy
        startActivity(intent) //lo ejecuta
        finish() //elimina de la pila la actividad
    }
}
