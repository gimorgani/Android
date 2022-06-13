package com.exercicio.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.exercicio.todo.databinding.FragmentFormBinding
import com.exercicio.todo.databinding.FragmentListBinding
import com.exercicio.todo.fragment.DatePickerFragment
import com.exercicio.todo.fragment.timerpickerlistenner
import com.exercicio.todo.modelo.Categoria
import java.time.LocalDate


class FormFragment : Fragment() ,timerpickerlistenner {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.listcategoria()

        mainViewModel.dataselecionada.value = LocalDate.now()

        mainViewModel._mycategoriaResponse.observe(viewLifecycleOwner) {
           Log.d("Requisicao", it.body().toString())

            spinnercategoria(it.body())
        }


        mainViewModel.dataselecionada.observe(viewLifecycleOwner){

            selectdate -> binding.editData.setText(selectdate.toString())
        }
        binding.botaosalvar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_listFragment)

        }

        binding.editData.setOnClickListener{

          DatePickerFragment(this).show(parentFragmentManager,"datepicker")
        }
        return binding.root

    }
    fun spinnercategoria (listcategoria: List<Categoria>?){
        if (listcategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listcategoria
                )

        }
    }

    override fun onDateSelect(date: LocalDate) {
        mainViewModel.dataselecionada.value = date
    }
}
