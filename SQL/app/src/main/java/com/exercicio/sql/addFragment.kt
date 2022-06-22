package com.exercicio.sql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.exercicio.sql.data.Usuario
import com.exercicio.sql.databinding.FragmentAddBinding


class addFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainviewmodel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater,container,false)

        mainviewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonadd.setOnClickListener {

            inserirnobanco()
        }

        return binding.root


    }

   private fun verificarcampos (nome:String,sobrenome:String, idade:String):Boolean{
        return ! (nome == "" || sobrenome == ""|| idade == "")
    }


     fun inserirnobanco (){
        val nome = binding.Textnome.text.toString()
        val sobrenome = binding.Textsobrenome.text.toString()
        val idade = binding.textoidade.text.toString()
        if (verificarcampos(nome,sobrenome,idade)){
            val user = Usuario(0, nome, sobrenome, idade.toInt())
            mainviewmodel.adduser(user)
            Toast.makeText(context,"Usuario Cadastrado!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else {
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
        }

    }
