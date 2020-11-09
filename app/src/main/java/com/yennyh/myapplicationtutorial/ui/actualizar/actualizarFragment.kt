package com.yennyh.myapplicationtutorial.ui.actualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor
import com.yennyh.myapplicationtutorial.databinding.FragmentActualizarBinding
import com.yennyh.myapplicationtutorial.misdeudores


class actualizarFragment : Fragment() {
    private lateinit var binding: FragmentActualizarBinding
    private var isShearing = true
    private var idDeudor = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actualizar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        binding = FragmentActualizarBinding.bind(view)
        binding.modificarButton.setOnClickListener {
            val nombre =
                binding.nombreBuscarEditText.text.toString()  //   se obtienen los valores en esos edit text
            val telefono = binding.telefonoEditText.text.toString()
            val valor = binding.valorEditText.text.toString()   //toString1 ??
            val deudorDAO = misdeudores.database.DeudorDAO()    //lleva la tabla de la base de datos

            if (isShearing) { //buscando
                val deudor =
                    deudorDAO.searchDeudor(nombre)    //busca el item en la tabla con el nombre
                if (deudor != null) {
                    isShearing = false
                    idDeudor = deudor.id
                    binding.modificarButton.text = getString(R.string.actualizar)
                    binding.telefonoEditText.setText(deudor.telefono?.toString())   //muestra los valores que habian anterior/ en la tabla
                    binding.valorEditText.setText(deudor.valor?.toString())
                } else {
                    binding.telefonoEditText.text = null
                    binding.valorEditText.text = null
                    Toast.makeText(context, "No existe", Toast.LENGTH_LONG).show()
                }
            } else { //acualizando
                val deudor = Deudor(
                    idDeudor,
                    nombre,
                    telefono.toLong(),
                    valor.toLong()
                )  //crea nuevo item de tabla
                deudorDAO.updateDeudor(deudor)
                isShearing = true
                binding.modificarButton.text = getString(R.string.buscar)
                Toast.makeText(context, "Se actualizó deudor", Toast.LENGTH_LONG).show()
            }

        }
    }

    companion object
}