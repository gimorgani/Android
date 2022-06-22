package com.exercicio.sql

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercicio.sql.data.UserDao
import com.exercicio.sql.data.UserDataBase
import com.exercicio.sql.data.UserRepository
import com.exercicio.sql.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel( application: Application): AndroidViewModel(application) {
    val selectuser : LiveData<List<Usuario>>
    val repository : UserRepository

    init {

        val userdao = UserDataBase.getdatabase(application).userdao()
        repository = UserRepository(userdao)
        selectuser = repository.selectuser
    }

    fun adduser (usuario: Usuario){
        viewModelScope.launch (Dispatchers.IO) {
            repository.adduser(usuario)
        }
    }
}