package com.yennyh.myapplicationtutorial.ui.actualizar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.databinding.FragmentActualizarBinding
import com.yennyh.myapplicationtutorial.misdeudores


class actualizarFragment : Fragment() {
    private lateinit var binding: FragmentActualizarBinding

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
            val nombre = binding.nombreBuscarEditText.text.toString()
            val deudorDAO = misdeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)
            if( deudor != null){
                binding.telefonoEditText.setText(deudor.telefono?.toString())
                binding.valorEditText.setText(deudor.valor?.toString())
            }

        }
    }

    companion object {
        }
}