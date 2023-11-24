package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class E1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e1)

        var configuracion = findViewById<ImageButton>(R.id.config)
        var mensajes = findViewById<ImageButton>(R.id.mensajeria)
        var guias = findViewById<ImageButton>(R.id.guiaa)
        var datos = findViewById<ImageButton>(R.id.informacion)
            var inicio = findViewById<ImageButton>(R.id.inicio)
            var historial = findViewById<ImageButton>(R.id.histo)

          configuracion.setOnClickListener {
               val intent = Intent(this, J1::class.java)
               startActivity(intent)
               finishAffinity()
           }
          mensajes.setOnClickListener {
             val intent = Intent(this, E2::class.java)
             startActivity(intent)
             finishAffinity()
         }

        datos.setOnClickListener {
            val intent = Intent(this, I2::class.java)
            startActivity(intent)
            finishAffinity()
        }
          guias.setOnClickListener {
           val intent = Intent(this, B4::class.java)
           startActivity(intent)
           finishAffinity()}

        historial.setOnClickListener {
           val intent = Intent(this, D1::class.java)
           startActivity(intent)
           finishAffinity()
       }
        inicio.setOnClickListener {
           val intent = Intent(this, C1::class.java)
           startActivity(intent)
           finishAffinity()
       }
    }
}