package com.exercicio.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercicio.todo.adapter.Tarefaadapter
import com.exercicio.todo.databinding.ActivityMainBinding
import com.exercicio.todo.databinding.FragmentListBinding
import com.exercicio.todo.modelo.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {



private lateinit var binding:FragmentListBinding
private val mainviewmodel : MainViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentListBinding.inflate(layoutInflater,container,false)

        mainviewmodel.listtarefa()




        val adapter =Tarefaadapter()

        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)



        binding.floatingAdd.setOnClickListener{
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        mainviewmodel.myTarefaResponse.observe(viewLifecycleOwner){
            response -> if(response.body()!= null){
                adapter.setList(response.body()!!)
        }
        }
        return binding.root
    }


}