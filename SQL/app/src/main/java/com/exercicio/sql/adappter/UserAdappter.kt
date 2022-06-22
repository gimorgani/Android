package com.exercicio.sql.adappter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exercicio.sql.data.Usuario
import com.exercicio.sql.databinding.CardLayoutBinding

class UserAdappter: RecyclerView.Adapter<UserAdappter.Userviewholder>(){
    var listausuario = emptyList<Usuario>()

    class Userviewholder (val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Userviewholder {
       return Userviewholder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Userviewholder, position: Int) {
       val user = listausuario[position]

        holder.binding.textId.text = user.id.toString()
        holder.binding.textonome.text = user.nome.toString()
        holder.binding.textsobrenome.text = user.sobrenome.toString()
        holder.binding.textidade.text = user.idade.toString()
    }

    override fun getItemCount(): Int {
       return listausuario.size
    }

    fun setlist (list: List<Usuario>){
        listausuario = list
        notifyDataSetChanged()
    }
}