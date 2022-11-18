package com.example.tpgrupo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class endGame : AppCompatActivity() {
    lateinit var inicio:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        inicio=findViewById(R.id.button)
        inicio.setOnClickListener {
            val lanzar = Intent(this, MainActivity::class.java)
            startActivity(lanzar)
        }
    }
}