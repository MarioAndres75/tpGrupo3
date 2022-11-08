package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible


class pantallaJuego : AppCompatActivity() {
    lateinit var textoAMostrar:TextView
    lateinit var ayuda:Button
    lateinit var palabraIngresada:EditText
    lateinit var chance:Button
    lateinit var ayudaCapital :TextView
    lateinit var ayudaContinente:TextView
    lateinit var ayudaBandera : ImageView

    val palabra= "ARGENTINA"
    var contadorAyudas=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        ayudaCapital=findViewById(R.id.ayudaCapital)
        ayudaContinente=findViewById(R.id.ayudaContinente)
        ayudaBandera=findViewById(R.id.bandera)
        textoAMostrar = findViewById(R.id.texto)
        ayuda = findViewById(R.id.ayuda)
        palabraIngresada=findViewById(R.id.palabraIngresada)
        chance=findViewById(R.id.chance)


        textoAMostrar.text = crearPalabra(palabra)
         ayuda.setOnClickListener {
            textoAMostrar.text = crearPalabra(palabra)
            palabraIngresada.text.clear()
            contadorAyudas++
            if (contadorAyudas==1) {ayudaCapital.text="BUENOS AIRES"}
            if (contadorAyudas==2){ayudaContinente.text="AMERICA"}
            if (contadorAyudas==3){
                ayudaBandera.setImageResource(R.drawable.bandera)
                ayuda.text="Me Rindo"}//hacer visible bandera y cambiar texto de boton ayuda por rendirse
            if (contadorAyudas==4){
                val lanzar = Intent(this, MainActivity::class.java)
                startActivity(lanzar)
            } // pasar  al siguiente

        }
        chance.setOnClickListener {
            val palabraArriesgada = palabraIngresada.text.toString()
            if (palabraArriesgada == palabra) textoAMostrar.text = "EXITO"
            else textoAMostrar.text="ERROR"
        }

    }





    fun crearPalabra(palabra:String): String {
        var palabraFinal= arrayOfNulls<Char>(palabra.length)
        var posicionRepetidaNo= arrayOfNulls<Int>(palabra.length)
        val cantidadDeLetras =palabra.length
        var contador=0
        var posicion =0
        var letra : Char
        var retorno=""
        var salir=0
        while (contador<cantidadDeLetras ) {
            while (salir==0) {  // impide que se repita alguna letra de la palabra original
                posicion = (Math.random() * cantidadDeLetras).toInt()
                if (posicionRepetidaNo.contains(posicion))
                else {
                    posicionRepetidaNo[contador] = posicion
                    salir=1
                }
            }
            salir=0
            letra = palabra.get(posicion) //busca una letra de la palabra original
            palabraFinal[contador] = letra  // coloca la letra en la palabra desordenada
            contador++
        }
        palabraFinal.forEach {

            retorno="$retorno$it"  //arma la palabra en un string
        }
        return retorno
    }

}