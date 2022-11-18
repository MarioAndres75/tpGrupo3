package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class easyMode : AppCompatActivity() {
    lateinit var jugadorPunaje: TextView
    lateinit var bandera: ImageView
    lateinit var mensaje: TextView
    lateinit var pais1: Button
    lateinit var pais2: Button
    lateinit var pais3: Button
    lateinit var pais4: Button
    var paisCorrecto="ARGENTINA"
    var paisAmostrar="FRANCIA"
    var paisBmostrar="RUSIA"
    var paisCmostrar="ESPAÑA"
    var paisDmostrar="CHILE"
    var posicion =1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_mode)
       jugadorPunaje=findViewById(R.id.jugadorYpunaje)
        bandera=findViewById(R.id.banderaEasy)
        mensaje=findViewById(R.id.mensajeEasy)
        pais2=findViewById(R.id.pais2Easy)
        pais3=findViewById(R.id.pais3Easy)
        pais4=findViewById(R.id.pais4Easy)
        pais1=findViewById(R.id.pais1Easy)
        imprimePuntaje()
        colocarPaisesEnPantalla()
        pais1.setOnClickListener {
            intento(pais1.text.toString())
        }
        pais2.setOnClickListener {
            intento(pais2.text.toString())
        }
        pais3.setOnClickListener {
            intento(pais3.text.toString())
        }
        pais4.setOnClickListener {
            intento(pais4.text.toString())
        }

    }

    private fun imprimePuntaje() {
        jugadorPunaje.text="$nombreJugador Tu puntaje: $puntajeJugador / vidas: $vidas"
    }

    private fun intento(paisElegido: String) {
        if(paisElegido==paisCorrecto){
            puntajeJugador= puntajeJugador+5

            //ir a pantalla de acierto
        }else{ // ir a pantalla de error
            vidas--
            if (vidas==0){ irAPantallaEndGame()} // ir a pantalla de game over
    }
        imprimePuntaje()
        colocarPaisesEnPantalla()

    }

    private fun irAPantallaEndGame() {
        val lanzar = Intent(this, endGame::class.java)
        startActivity(lanzar)
    }

    private fun colocarPaisesEnPantalla() {
        posicion = (Math.random() * 3).toInt()+1
        pais1.text=paisAmostrar
        pais2.text=paisBmostrar
        pais3.text=paisCmostrar
        pais4.text=paisDmostrar
        if (posicion==1)pais1.text=paisCorrecto
        if (posicion==2)pais2.text=paisCorrecto
        if (posicion==3)pais3.text=paisCorrecto
        if (posicion==4)pais4.text=paisCorrecto


    }
}