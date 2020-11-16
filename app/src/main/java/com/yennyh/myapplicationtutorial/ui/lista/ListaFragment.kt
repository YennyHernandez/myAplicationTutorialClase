package com.yennyh.myapplicationtutorial.ui.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.server.DeudorServer
import com.yennyh.myapplicationtutorial.databinding.FragmentListaBinding

class ListaFragment : Fragment() {
    private lateinit var deudoresRVAdapter: DeudoresRVAdapter   //usado para bases de datos con firebaserealtime
    private lateinit var binding: FragmentListaBinding

    //var listDeudores: List<Deudor> = emptyList()  usado para base de datos con ROOM
    var listDeudores: MutableList<DeudorServer> =
        mutableListOf()   //usado para bases de datos con firebaserealtime

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListaBinding.bind(view)
        binding.deudoresRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.deudoresRecyclerView.setHasFixedSize(true)
        //val deudoresRVAdapter = DeudoresRVAdapter(listDeudores as ArrayList<Deudor>)  usado para base de datos con ROOM
        deudoresRVAdapter = DeudoresRVAdapter(listDeudores as ArrayList<DeudorServer>)
        binding.deudoresRecyclerView.adapter =
            deudoresRVAdapter   // hay que cargarle la información
        // cargarDesdeDatabase()
        cargarDesdeFirebase()
        deudoresRVAdapter.notifyDataSetChanged()
    }

    /* private fun cargarDesdeDatabase() {
         val deudorDAO = misdeudores.database.DeudorDAO()   // traen la infomacion ROOM
         listDeudores = deudorDAO.getDeudores()  //hasta aqui se crea lista vacia,se obtienen deudores ROOM
     }*/

    private fun cargarDesdeFirebase() {
        val database = FirebaseDatabase.getInstance()   //instancia
        val myDeudoresRef = database.getReference("deudores")  //referencia

        listDeudores.clear()

        val postListener =
            object : ValueEventListener {  //hace un llamado y devuelve la información que contiene
                override fun onDataChange(snapshot: DataSnapshot) {  //snaps es la data
                    for (dato: DataSnapshot in snapshot.children) { // recorrera todos los hijos (items de tabla)
                        val deudorServer =
                            dato.getValue(DeudorServer::class.java)  //lo guarda en una variable
                        deudorServer?.let { listDeudores.add(it) } //lo agrega a la lista
                    }
                    deudoresRVAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                }
            }

        myDeudoresRef.addValueEventListener(postListener)  //agrega la información cargada
    }

}

