package com.exercicio.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.exercicio.todo.databinding.FragmentFormBinding
import com.exercicio.todo.databinding.FragmentListBinding
import com.exercicio.todo.fragment.DatePickerFragment
import com.exercicio.todo.fragment.timerpickerlistenner
import com.exercicio.todo.modelo.Categoria
import com.exercicio.todo.modelo.Tarefa
import java.time.LocalDate


class FormFragment : Fragment() ,timerpickerlistenner {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var categoriaselecionada = 0L

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

            inserirnobanco()
        }

        binding.editData.setOnClickListener{

          DatePickerFragment(this).show(parentFragmentManager,"datepicker")
        }
        return binding.root

    }
   private fun spinnercategoria (listcategoria: List<Categoria>?){
        if (listcategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listcategoria
                )
            binding.spinnerCategoria.onItemSelectedListener =
                object: AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selected = binding.spinnerCategoria.selectedItem as Categoria
                        categoriaselecionada = selected.id
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
        }
    }
    private fun validarcampos (nome:String, descricao: String, responsavel:String
    ): Boolean{
             return !(
                        (nome == ""||nome.length<3||nome.length>20)||
                        (descricao ==""||descricao.length<3||descricao.length>200)||
                        (responsavel ==""||responsavel.length<3||responsavel.length>20)

                     )


    }

    private fun inserirnobanco(){
        val nome = binding.editNome.text.toString()
        val des = binding.editDescricao.text.toString()
        val resp = binding.editResponsavel.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchAtivoCard.isChecked
        val categoria = Categoria(categoriaselecionada,null,null)


        if(validarcampos(nome, des,resp)){
            val tarefa = Tarefa(0,nome,des,resp,data,status,categoria)
        mainViewModel.addtarefa(tarefa)
            Toast.makeText(context,"Tarefa Cadastrada",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)


    }else{
            Toast.makeText(context,"Verifique os campos novamente!",Toast.LENGTH_SHORT).show()

        }    }


    override fun onDateSelect(date: LocalDate) {
        mainViewModel.dataselecionada.value = date
    }
}
