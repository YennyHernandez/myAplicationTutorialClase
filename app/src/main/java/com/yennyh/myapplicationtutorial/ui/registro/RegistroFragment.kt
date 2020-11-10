package com.yennyh.myapplicationtutorial.ui.crear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.RegistroDAO
import com.yennyh.myapplicationtutorial.data.database.entities.Registro
import com.yennyh.myapplicationtutorial.databinding.FragmentRegistroBinding
import com.yennyh.myapplicationtutorial.miregistro
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
        binding.registrarButton.setOnClickListener{
            val nombre = binding.nombreEditText.text.toString()
            val email = binding.correoEditText.text.toString()
            val contrasena =  binding.contrasenaEditText.text.toString()
            val registro = Registro(NULL, nombre, email, contrasena)
            val  registroDAO :RegistroDAO = miregistro.database.RegistroDAO()
            registroDAO.insertRegistro(registro)  //se insertan los datos por medio de la funcion insert
        }

    }
    companion object {

    }
}