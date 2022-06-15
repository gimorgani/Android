package com.exercicio.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercicio.todo.api.Repositorio
import com.exercicio.todo.modelo.Categoria
import com.exercicio.todo.modelo.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

/*inject usa a instancia do construtor para mostrar que vamos trazer o repositorio
* o hiltviewmodel é usado para mostrar que na view model pode acontecer um hilt*/
@HiltViewModel
class MainViewModel @Inject constructor (val repositorio: Repositorio) :
    ViewModel() {


    private val myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()
    val _mycategoriaResponse: LiveData<Response<List<Categoria>>> = myCategoriaResponse

    val dataselecionada = MutableLiveData<LocalDate>()

    private val _myTarefaResponse =
        MutableLiveData<Response<List<Tarefa>>>()
    val myTarefaResponse: LiveData<Response<List<Tarefa>>> = _myTarefaResponse

    init {
        //listcategoria()
    }

    fun listcategoria() {

        viewModelScope.launch {
            try {
                val response = repositorio.listacategoria()
                myCategoriaResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }


        }

    }

    fun addtarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            try {
                repositorio.addtarefa(tarefa)

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listtarefa() {
        viewModelScope.launch {
            try {
                val response = repositorio.listtarefa()
                _myTarefaResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }
}
