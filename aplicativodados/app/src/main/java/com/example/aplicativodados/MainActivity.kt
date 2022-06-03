package com.example.aplicativodados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bot6 = findViewById<Button>(R.id.dado6)
        val bot12 = findViewById<Button>(R.id.dado12)
        val bot20 = findViewById<Button>(R.id.dado20)
        bot6.setOnClickListener {

            rolagem(6)

        }

            bot12.setOnClickListener {
                rolar(12)
            }

                bot20.setOnClickListener {

                    rolagens(20)
                }


    }

    private fun rolagem(lados: Int) {
        val rolagem = (1..lados).random()
        val textdado = findViewById<TextView>(R.id.textodado)
        textdado.text = rolagem.toString()
        val imagem = findViewById<ImageView>(R.id.imagem)
        when (rolagem) {
            1 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_131011_img1_gratispng_com)
            2 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_131029_img1_gratispng_com)
            3 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_13112_img1_gratispng_com)
            4 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_131128_img1_gratispng_com)
            5 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_131138_img1_gratispng_com)
            6 -> imagem.setImageResource(R.drawable.captura_da_web_3_6_2022_131150_img1_gratispng_com)


        }
    }

    private fun rolar(lados: Int) {
        val rolar = (1..lados).random()
        val textdado = findViewById<TextView>(R.id.textodado)
        textdado.text = rolar.toString()
    }

    private fun rolagens(lados: Int) {
        val rolagens = (1..lados).random()
        val textdado = findViewById<TextView>(R.id.textodado)
        textdado.text = rolagens.toString()
    }
}

