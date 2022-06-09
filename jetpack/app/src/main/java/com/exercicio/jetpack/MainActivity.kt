package com.exercicio.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exercicio.jetpack.databinding.ActivityMainBinding
/* para ter acesso aos componentes da activity main*/

private lateinit var binding: ActivityMainBinding
private lateinit var mainviewmodel: Mainviewmodel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   mainviewmodel =ViewModelProvider(this).
        get(Mainviewmodel::class.java)


        mainviewmodel.cont.observe(this){

            binding.textresultado.text = it.toString()
        }


        binding.buttonclique.setOnClickListener {
            mainviewmodel.addnum()


        }
    }

}