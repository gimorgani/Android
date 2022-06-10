package com.exercicio.todo.di

import com.exercicio.todo.api.Repositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides

    fun returnrepositorio () : Repositorio{
        return Repositorio()
    }
}