package com.yennyh.myapplicationtutorial.ui.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.DeudorDAO
import com.yennyh.myapplicationtutorial.databinding.FragmentBorrarBinding
import com.yennyh.myapplicationtutorial.misdeudores

class borrar_Fragment : Fragment() {
    private lateinit var binding: FragmentBorrarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        binding = FragmentBorrarBinding.bind(view)
        binding.buttonBorrar.setOnClickListener {
            val nombre = binding.nombreBorrarEditText.text.toString()
            val deudorDAO: DeudorDAO = misdeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)
            if (deudor != null ){
                deudorDAO.deleteDeudor(deudor)
            }
            else{
                Toast.makeText(context,"NO EXISTE DEUDOR", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object
}