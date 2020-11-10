package com.yennyh.myapplicationtutorial.ui.registro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.RegistroDAO
import com.yennyh.myapplicationtutorial.data.database.entities.Registro
import com.yennyh.myapplicationtutorial.databinding.FragmentRegistroBinding
import com.yennyh.myapplicationtutorial.misdeudores
import com.yennyh.myapplicationtutorial.ui.login.LoginActivity
import java.sql.Types.NULL

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding //lo que se agrega al usar binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // super.onViewCreated(view, savedInstanceState) lo que viene normalmente antes de usar binding
        binding = FragmentRegistroBinding.bind(view)
        binding.registrarButton.setOnClickListener {
            val nombre = binding.nombreEditText.text.toString()
            val email = binding.correoEditText.text.toString()
            val contrasena = binding.contrasenaEditText.text.toString()
            val registro = Registro(NULL, nombre, email, contrasena)
            val registroDAO: RegistroDAO = misdeudores.database.RegistroDAO()
            val user =
                registroDAO.insertRegistro(registro)  //se insertan los datos por medio de la funcion insert

            if (user != null) {
                val intent = Intent(context, LoginActivity::class.java) //configuro para donde voy
                startActivity(intent) //lo ejecuta
            } else {
                Toast.makeText(context, "Ocurrio algún error al registrarse!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}