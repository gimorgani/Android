package com.exercicio.todo.api

import com.exercicio.todo.modelo.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")
    suspend fun  listcategoria (): Response<List<Categoria>>
}