package com.yennyh.myapplicationtutorial.ui.splash
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.bottom.BottomActivity
import com.yennyh.myapplicationtutorial.ui.login.LoginActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val timer = Timer()
        timer.schedule(
            timerTask {

                val auth =
                    FirebaseAuth.getInstance().currentUser //comprueba si esta logueado y va navegar  si no va a login
                if (auth == null) {   //auth contiene toda la informacion del usuario
                    goToLoginActivity()
                } else {
                    goToBottomActivity()
                }
            }, 2000
        )
    }

    fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goToBottomActivity() {
        val intent = Intent(this, BottomActivity::class.java)
        startActivity(intent)
        finish()
    }


}
