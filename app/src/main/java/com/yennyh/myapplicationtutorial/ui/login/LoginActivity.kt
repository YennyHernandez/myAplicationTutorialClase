package com.yennyh.myapplicationtutorial.ui.login
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.ui.bottom.BottomActivity
import com.yennyh.myapplicationtutorial.ui.registro.RegistroActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth //paso 1

    companion object {
        private val TAG = RegistroActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()  //paso 2

        ingresar_button2.setOnClickListener {
            val correo = email_editTextText2.text.toString()
            val contrasena = contrasena_editTextText2.text.toString()

            loginWithFirebase(correo, contrasena)
        }

        registrar_login_button2.setOnClickListener {
            /*val intent = Intent(this, RegistroActivity::class.java)
            intent.putExtra("numero", 100)
            startActivity(intent)
            finish()   pasaba a actividad de registro
            */
            goToRegisterActivity()
        }
    }

    private fun loginWithFirebase(correo: String, contrasena: String) {
        auth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    goToBottomActivity()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun goToBottomActivity() {
        val intent = Intent(this, BottomActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegisterActivity() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }
}