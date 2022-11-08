package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var power:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        power=findViewById(R.id.power)
        power.setOnClickListener {
            val lanzar = Intent(this, pantallaJuego::class.java)
            startActivity(lanzar)
        }
    }
}