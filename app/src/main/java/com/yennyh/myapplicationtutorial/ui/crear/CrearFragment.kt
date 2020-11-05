package com.yennyh.myapplicationtutorial.ui.crear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.DeudorDAO
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor
import com.yennyh.myapplicationtutorial.databinding.FragmentCrearBinding
import com.yennyh.myapplicationtutorial.misdeudores
import java.sql.Types.NULL

class CrearFragment : Fragment() {

    private lateinit var binding: FragmentCrearBinding //lo que se agrega al usar binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // super.onViewCreated(view, savedInstanceState) lo que viene normalmente antes de usar binding
        binding = FragmentCrearBinding.bind(view)
        binding.guardarButton.setOnClickListener{
            val nombre = binding.nombreTextInputEditText.text.toString()
            val telefono = binding.telefonoTextInputEditText.text.toString().toLong()
            val valor =  binding.deudaTextInputEditText.text.toString().toLong()
            val deudor = Deudor(NULL, nombre, telefono, valor)
            val deudorDAO :DeudorDAO = misdeudores.database.DeudorDAO()  //aqui ya tenemos acceso al DAO
            deudorDAO.insertDeudor(deudor)  //se insertan los datos por medio de la funcion insert
        }
     /* con syntetic
        guardar_button.setOnClickListener{
            val nombre = nombre_textInputEditText.text.toString()
            val telefono = telefono_textInputEditText.text.toString()
            val valor =  deuda_textInputEditText.text.toString().toLong()
            val deudor = Deudor(nombre, telefono, valor)
           // Log.d("deudor", deudor.nombre)     muestra en consola para pruebas
           // Toast.makeText(context,"si entro",Toast.LENGTH_SHORT).show() muestra como mensaje para pruebas
        }*/
    }
    companion object {

    }
}