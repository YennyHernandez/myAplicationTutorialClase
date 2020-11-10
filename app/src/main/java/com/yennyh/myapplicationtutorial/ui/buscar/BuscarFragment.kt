package com.yennyh.myapplicationtutorial.ui.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.DeudorDAO
import com.yennyh.myapplicationtutorial.databinding.FragmentBuscarBinding
import com.yennyh.myapplicationtutorial.misdeudores


class BuscarFragment : Fragment() {

    private lateinit var binding: FragmentBuscarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBuscarBinding.bind(view)
        binding.buscarButton.setOnClickListener {
            val nombre = binding.buscarInputEditText.text.toString()

            val deudorDAO: DeudorDAO =
                misdeudores.database.DeudorDAO()  //aqui volvemos a tener acceso al DAQ
            val deudor = deudorDAO.searchDeudor(nombre)
            if (deudor != null) {
                binding.telefonoTextView.text = deudor.telefono.toString()
                binding.valorDeudaTextView.text = deudor.valor.toString()
            } else {
                Toast.makeText(context, "NO EXISTE DEUDOR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


