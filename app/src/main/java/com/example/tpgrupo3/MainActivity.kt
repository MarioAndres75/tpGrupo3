package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
var nombreJugador="MARIO"
var puntajeJugador=0
var vidas=3
class MainActivity : AppCompatActivity() {

    lateinit var easy:Button
    lateinit var expert :Button
    lateinit var nombre:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        easy=findViewById(R.id.facil)
        expert=findViewById(R.id.dificil)
        nombre=findViewById(R.id.nombre)
         puntajeJugador=0
         vidas=3
        expert.setOnClickListener {
            nombreJugador=nombre.text.toString()
            val lanzar = Intent(this, pantallaJuego::class.java)
            startActivity(lanzar)
        }
        easy.setOnClickListener {
            nombreJugador=nombre.text.toString()
            val lanzar = Intent(this, easyMode::class.java)
            startActivity(lanzar)
        }
    }
}