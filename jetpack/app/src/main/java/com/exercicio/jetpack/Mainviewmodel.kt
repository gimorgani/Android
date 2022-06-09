package com.exercicio.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mainviewmodel :ViewModel() {
    var cont = MutableLiveData<Int> (0)

    fun addnum (){

        cont.value = cont.value?.plus(1)
    }


}