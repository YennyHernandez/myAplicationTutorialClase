package com.yennyh.myapplicationtutorial.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.yennyh.myapplicationtutorial.R
import com.yennyh.myapplicationtutorial.data.database.entities.Deudor
import com.yennyh.myapplicationtutorial.databinding.DeudoresItemBinding

class DeudoresRVAdapter(var deudoresList:ArrayList<Deudor>):RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeudoresViewHolder {//inflar item
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.deudores_item, parent, false)
        return DeudoresViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: DeudoresViewHolder,
        position: Int
    ) {  //datos que voy a mostrar de la lista dependiendo de la posicion
        val deudor = deudoresList[position]
        holder.bindDeudor(deudor)

    }

    override fun getItemCount(): Int { //retorna el tamaño de la lista n veces
        return deudoresList.size
    }

    class DeudoresViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) { //coloca los datos en item, setea la informacion de las cajas
        private val binding = DeudoresItemBinding.bind(itemView)
        fun bindDeudor(deudor: Deudor) {
            binding.nombreTextView.text = deudor.nombre
            binding.valorTextView.text = deudor.valor.toString()
        }
    }

}
