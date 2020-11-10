package com.yennyh.myapplicationtutorial.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.RegistroDAO
import com.yennyh.myapplicationtutorial.databinding.FragmentLoginBinding
import com.yennyh.myapplicationtutorial.misdeudores
import com.yennyh.myapplicationtutorial.ui.bottom.BottomActivity
import com.yennyh.myapplicationtutorial.ui.registro.RegistroActivity


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.bind(view)
        binding.ingresarButton.setOnClickListener {
            val email = binding.emailEditTextText.text.toString()
            val contrasena = binding.contrasenaEditTextText.text.toString()

            val deudorDAO: RegistroDAO =
                misdeudores.database.RegistroDAO() //aqui volvemos a tener acceso al DAQ
            val userEmail = deudorDAO.searchEmail(email)
            if (userEmail != null && userEmail.contrasena == contrasena) {
                val intent = Intent(context, BottomActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "ERROR EN USUARIO O CONTRASEÑA", Toast.LENGTH_SHORT).show()
            }
        }
        binding.registrarLoginButton.setOnClickListener {
            val intent = Intent(context, RegistroActivity::class.java) //configuro para donde voy
            startActivity(intent) //lo ejecuta
        }
    }
}
