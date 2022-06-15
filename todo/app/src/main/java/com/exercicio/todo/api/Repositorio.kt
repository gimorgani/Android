package com.exercicio.todo.api

import com.exercicio.todo.modelo.Categoria
import com.exercicio.todo.modelo.Tarefa
import retrofit2.Response

class Repositorio {

    suspend fun listacategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listcategoria()
    }

    suspend fun addtarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.addtarefa(tarefa)
    }
    suspend fun listtarefa(): Response<List<Tarefa>>{
        return RetrofitInstance.api.listtarefa()
    }
}