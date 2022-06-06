package com.exercicio.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val proximo = findViewById<Button>(R.id.proxima)

        val intentedois = Intent(this,Activitydois::class.java)
        proximo.setOnClickListener {
            startActivity(intentedois)
        }
        }



    override fun onStart() {
        super.onStart()
        Log.d( "ciclo", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ciclo","onResume()")
    }
    override fun onPause(){
        super.onPause()
        Log.d("Ciclo","onPause()")
    }
    override fun onStop(){
        super.onStop()
        Log.d("Ciclo","onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ciclo", "onRestart()")
    }
}