package com.exercicio.todo.api

import com.exercicio.todo.modelo.Categoria
import retrofit2.Response

class Repositorio {

    suspend fun listacategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listcategoria()
    }
}