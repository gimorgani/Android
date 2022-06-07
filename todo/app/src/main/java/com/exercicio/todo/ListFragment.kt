package com.exercicio.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercicio.todo.adapter.Tarefaadapter
import com.exercicio.todo.databinding.ActivityMainBinding
import com.exercicio.todo.databinding.FragmentListBinding
import com.exercicio.todo.modelo.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {



private lateinit var binding:FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentListBinding.inflate(layoutInflater,container,false)



        val listatarefa = listOf(
            Tarefa(
                "Arrumar a casa",
                "Arrumar a casa todos os dias",
                "Giovanna",
            "11/03/2023",
                false,
                "diariamente"
            ) ,
            Tarefa(
                    "Lavar a roupa",
            "Lavar a roupa todos os dias",
            "Lucas",
            "14/05/2023",
            false,
            "diariamente"
        ),
        Tarefa(
            "Varer a casa",
            "Varrer a casa todos os dias",
            "Maria",
            "16/01/2023",
            false,
            "diariamente"
        )
        )

        val adapter =Tarefaadapter()

        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)
        adapter.setList(listatarefa)


        binding.floatingAdd.setOnClickListener{
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        return binding.root
    }


}