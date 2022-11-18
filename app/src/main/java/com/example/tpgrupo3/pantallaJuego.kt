package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class pantallaJuego : AppCompatActivity() {
    lateinit var textoAMostrar:TextView
    lateinit var ayuda:Button
    lateinit var palabraIngresada:EditText
    lateinit var chance:Button
    lateinit var ayudaCapital :TextView
    lateinit var ayudaContinente:TextView
    lateinit var ayudaBandera : ImageView
    lateinit var puntajePorGanar:TextView
    lateinit var datosUsuario:TextView
    var puntaje=5
    val nombrePais= "ARGENTINA"
    val nombreCapital="BUENOS AIRES"
    val nombreContinente="AMERICA"
    var contadorAyudas=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_juego)
        ayudaCapital=findViewById(R.id.ayudaCapital)
        ayudaContinente=findViewById(R.id.ayudaContinente)
        ayudaBandera=findViewById(R.id.bandera)
        textoAMostrar = findViewById(R.id.paisDesordenado)
        ayuda = findViewById(R.id.ayuda)
        palabraIngresada=findViewById(R.id.palabraIngresada)
        chance=findViewById(R.id.chance)
        puntajePorGanar=findViewById(R.id.puntajePorGanar)
        datosUsuario=findViewById(R.id.nombreUsuario)
        puntajePorGanar.text= mensajePuntajeAGanar()
        datosUsuario.text=muestraDatosUsuario()
        textoAMostrar.text = crearPalabra(nombrePais)
         ayuda.setOnClickListener {
            textoAMostrar.text = crearPalabra(nombrePais)
            palabraIngresada.text.clear()

            contadorAyudas++

            if (contadorAyudas==1) { ayudaCapital.text=nombreCapital} //  primer ayuda

            if (contadorAyudas==2){ ayudaContinente.text=nombreContinente}//segunda ayuda

             if (contadorAyudas==3){//tercer ayuda
                ayudaBandera.setImageResource(R.drawable.bandera)
                ayuda.text="-X-"}//hacer visible bandera y cambiar texto de boton ayuda por rendirse

            if (contadorAyudas==4){//perdio vida va a pantalla de fracaso
                vidas--
                contadorAyudas=0
                puntaje=5
            //    val lanzar = Intent(this, MainActivity::class.java)
           //     startActivity(lanzar)

            } // pasar  al siguiente
            puntaje=5-contadorAyudas
            puntajePorGanar.text= mensajePuntajeAGanar()
             datosUsuario.text=muestraDatosUsuario()
             if (vidas==0){volverAPantallaPrincipal() }// game over
        }
        chance.setOnClickListener {
            val palabraArriesgada = palabraIngresada.text.toString()
            if (palabraArriesgada == nombrePais) {//pasa a pantalla de exito
                puntajeJugador= puntajeJugador + puntaje
               palabraIngresada.text.clear()
               }
            else {vidas--
                        }//pasa a pantalla de fracaso
            puntajePorGanar.text= mensajePuntajeAGanar()
            datosUsuario.text=muestraDatosUsuario()
            if (vidas==0){volverAPantallaPrincipal() }// game over
        }




    }
    fun muestraDatosUsuario(): String {
        var retorno="$nombreJugador / Puntaje: ${puntajeJugador.toString()}/ VIDAS: $vidas"
        return retorno
    }

    fun volverAPantallaPrincipal(){
        val lanzar = Intent(this, MainActivity::class.java)
        startActivity(lanzar)
    }

    fun mensajePuntajeAGanar(): String {
        val retorno= "JUGAS POR: ${puntaje.toString()} PUNTOS "
        return retorno
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