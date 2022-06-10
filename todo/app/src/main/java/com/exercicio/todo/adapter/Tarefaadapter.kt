package com.exercicio.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exercicio.todo.databinding.CardBinding
import com.exercicio.todo.modelo.Tarefa

class Tarefaadapter :RecyclerView.Adapter<Tarefaadapter.tarefaviewholder>(){

 private var listTarefa = emptyList<Tarefa>()

    class tarefaviewholder(val binding: CardBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tarefaviewholder {
      return tarefaviewholder( CardBinding.inflate
          (LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: tarefaviewholder, position: Int) {
        val tarefas = listTarefa[position]
        holder.binding.texttarefa.text = tarefas.nome
        holder.binding.textDescri.text = tarefas.descricao
        holder.binding.textresponsavel.text = tarefas.responsavel
        holder.binding.textdata.text = tarefas.data
        holder.binding.switch1.isChecked = tarefas.status
        holder.binding.textcategoria.text = tarefas.categoria.descricao
    }

    override fun getItemCount(): Int {
      return listTarefa.size
    }
    fun setList (list: List<Tarefa>){
        listTarefa = list
        notifyDataSetChanged()
    }
}