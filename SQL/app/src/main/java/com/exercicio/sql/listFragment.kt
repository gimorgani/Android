package com.exercicio.sql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercicio.sql.adappter.UserAdappter
import com.exercicio.sql.databinding.FragmentListBinding


class listFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater,container,false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val adapter = UserAdappter()

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)

        mainViewModel.selectuser.observe(viewLifecycleOwner){
            response -> adapter.setlist(response)
        }

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
            return binding.root
        }



    }
