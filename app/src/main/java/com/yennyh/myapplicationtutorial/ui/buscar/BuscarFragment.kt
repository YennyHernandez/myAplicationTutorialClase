package com.yennyh.myapplicationtutorial.ui.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.server.DeudorServer
import com.yennyh.myapplicationtutorial.databinding.FragmentBuscarBinding


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

            // buscarenDatabase(nombre)
            buscarEnfirebase(nombre)
        }
    }

    private fun buscarEnfirebase(nombre: String) {
        val database = FirebaseDatabase.getInstance()
        val myDeudorRef = database.getReference("deudores")
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (data: DataSnapshot in snapshot.children) {  //data queda con toda la informacion por snapshot
                    val deudorServer = data.getValue(DeudorServer::class.java)
                    if (deudorServer?.nombre.equals(nombre)) {  //toma nombre y lo compara con variable nombre
                        binding.telefonoTextView.text =
                            deudorServer?.telefono.toString()  //escribe en los campos
                        binding.valorDeudaTextView.text = deudorServer?.valor.toString()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        myDeudorRef.addValueEventListener(postListener)

    }

    /*private fun buscarenDatabase(nombre: String) {
        val deudorDAO: DeudorDAO =
            misdeudores.database.DeudorDAO()  //aqui volvemos a tener acceso al DAQ
        val deudor = deudorDAO.searchDeudor(nombre)
        if (deudor != null) {
            binding.telefonoTextView.text = deudor.telefono.toString()
            binding.valorDeudaTextView.text = deudor.valor.toString()
        } else {
            Toast.makeText(context, "NO EXISTE DEUDOR", Toast.LENGTH_SHORT).show()
        }
    }*/
}


