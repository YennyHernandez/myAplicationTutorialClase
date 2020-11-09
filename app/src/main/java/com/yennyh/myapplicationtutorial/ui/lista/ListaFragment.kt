package com.yennyh.myapplicationtutorial.ui.lista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.dao.DeudorDAO
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor
import com.yennyh.myapplicationtutorial.databinding.FragmentListaBinding
import com.yennyh.myapplicationtutorial.misdeudores
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment(){

     private lateinit var binding :FragmentListaBinding
    var listDeudores: List<Deudor> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListaBinding.bind(view)
        binding.deudoresRecyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.deudoresRecyclerView.setHasFixedSize(true)

        val deudorDAO = misdeudores.database.DeudorDAO()
        listDeudores = deudorDAO.getDeudores()  //hasta aqui se crea lista vacia,se obtienen deudores

        val deudoresRVAdapter = DeudoresRVAdapter(listDeudores as ArrayList<Deudor>)
        binding.deudoresRecyclerView.adapter = deudoresRVAdapter   // hay que cargarle la información

        deudoresRVAdapter.notifyDataSetChanged()
    }


}