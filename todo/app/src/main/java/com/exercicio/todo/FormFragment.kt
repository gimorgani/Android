package com.exercicio.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.exercicio.todo.databinding.FragmentFormBinding
import com.exercicio.todo.databinding.FragmentListBinding


class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentFormBinding.inflate(layoutInflater,container,false)

        binding.botaosalvar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }
        return binding.root

    }
}
