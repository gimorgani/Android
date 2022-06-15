package com.exercicio.todo.api

import com.exercicio.todo.modelo.Categoria
import com.exercicio.todo.modelo.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("categoria")
    suspend fun  listcategoria (): Response<List<Categoria>>

    @POST ("tarefa")
    suspend fun addtarefa (
        @Body tarefa: Tarefa) :Response<Tarefa>

    @GET ("tarefa")
    suspend fun listtarefa(): Response<List<Tarefa>>

}