package com.exercicio.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercicio.todo.api.Repositorio
import com.exercicio.todo.modelo.Categoria
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    val repositorio = Repositorio()

    private val myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()
    val _mycategoriaResponse : LiveData<Response<List<Categoria>>>
            = myCategoriaResponse


    fun listcategoria (){

        viewModelScope.launch {
           
                myCategoriaResponse.value = repositorio.listacategoria()



        }

    }
}