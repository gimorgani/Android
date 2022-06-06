package com.exercicio.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activitydois : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitydois)

        val voltar = findViewById<Button>(R.id.voltar)

        voltar.setOnClickListener {
            finish()
        }
    }
}