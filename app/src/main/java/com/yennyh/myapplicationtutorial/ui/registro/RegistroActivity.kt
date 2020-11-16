package com.yennyh.myapplicationtutorial.ui.registro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.server.Usuario
import com.yennyh.myapplicationtutorial.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*

//https://firebase.google.com/docs/auth/android/start#kotlin+ktx_1   pasos para registarse con firebase
class RegistroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    companion object {

        private val TAG = RegistroActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        /* paso de datos a otra actividad
        val datosRecibidos = intent.extras
        val numeroEnviado = datosRecibidos?.getInt("numero")
        Toast.makeText(this, "El número enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()


        Log.d("Método", "onCreate")*/
        auth = FirebaseAuth.getInstance()


        registrar_button2.setOnClickListener {
            val correo = correo_edit_text2r.text.toString()
            val contrasena = contrasena_edit_text2r.text.toString()
            val nombre = nombre_edit_text2r.text.toString()
            /* se pasa a otra actividad y se envia informacion
           val intent = Intent(this, LoginActivity::class.java)

            intent.putExtra("correo", correo)
            intent.putExtra("contrasena", contrasena)
            startActivity(intent)
            finish() */
            registroEnFirebase(correo, contrasena, nombre)

            /* otras opciones que se tenian en el registro xml
            val nombre = nombre_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val repContrasena = rep_contrasena_edit_text.text.toString()
            val genero =
                if (masculino_radio_button.isChecked) getString(R.string.masculino) else getString(R.string.femenino)
            var pasatiempos = EMPTY
            if (nadar_check_box.isChecked) pasatiempos += getString(R.string.nadar) + SPACE
            if (cine_check_box.isChecked) pasatiempos += getString(R.string.cine) + SPACE
            if (comer_check_box.isChecked) pasatiempos += getString(R.string.comer)
            val ciudadDeNacimiento = ciudad_nacimiento_spinner.selectedItem
            respuesta_text_view.text = getString(
                R.string.respuesta,
                nombre,
                correo,
                telefono,
                genero,
                pasatiempos,
                ciudadDeNacimiento
            ) */
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    //paso 3 firebase
    private fun registroEnFirebase(
        correo: String,
        contrasena: String,
        nombre: String
    ) {   //crea en base de datos (Autentificación)
        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->   //si se realizo lo anterior continua
                if (task.isSuccessful) {
                    val uid =
                        auth.currentUser?.uid  //copia el id asociado a ese registro que crea firebase automaticamente
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    CrearUsuarioEnBaseDeDatos(uid, correo, nombre)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun CrearUsuarioEnBaseDeDatos(
        uid: String?,
        correo: String,
        nombre: String
    ) {   //crea información en tabla de firebaserealtime
        val database = FirebaseDatabase.getInstance()
        val myUsersReference =
            database.getReference("usuarios")   //me paro en la tabla que deseo y si no existe la crea
        //val id = myUsersReference.push().key //agrega id aleatoriamente pero como queriamos el mismo del que se resistro uso eol uid
        val usuario = Usuario(uid, nombre, correo)  //instancia el objeto (clase usuario)
        uid?.let {
            myUsersReference.child(uid).setValue(usuario)
        }  // mejor practica para no quitar la propiedade de null
        goToLoginActivity()

    }

    private fun goToLoginActivity() {
        onBackPressed()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Método", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método", "onRestart")
    }

}