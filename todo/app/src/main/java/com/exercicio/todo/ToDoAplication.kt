package com.exercicio.todo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/*o hilt pode ser utilizado por tudo no meu app e fala pro hilt que esa classe
 que cuida de tudo*/
@HiltAndroidApp
class ToDoAplication : Application() {

}