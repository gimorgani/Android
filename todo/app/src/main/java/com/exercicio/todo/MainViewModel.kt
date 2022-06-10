package com.exercicio.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercicio.todo.api.Repositorio
import com.exercicio.todo.modelo.Categoria
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor (val repositorio: Repositorio) :
    ViewModel() {


    private val myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()
    val _mycategoriaResponse : LiveData<Response<List<Categoria>>>
            = myCategoriaResponse

    init {
        listcategoria()
    }

    fun listcategoria (){

        viewModelScope.launch {
           try{
               val response = repositorio.listacategoria()
               myCategoriaResponse.value = response

           }catch (e: Exception){
               Log.d("Erro",e.message.toString())
           }




        }

    }
}