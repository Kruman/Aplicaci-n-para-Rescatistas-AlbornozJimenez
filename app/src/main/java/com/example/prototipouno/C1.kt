package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class C1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c1)
        val reporte = findViewById<ImageButton>(R.id.reporte)
        val rescate = findViewById<ImageButton>(R.id.rescate)
        val adopcion= findViewById<ImageButton>(R.id.solicitud)
        val historial = findViewById<ImageButton>(R.id.historial)
        val cuenta = findViewById<ImageButton>(R.id.datos)
        val emer= findViewById<ImageButton>(R.id.emergencia)

        reporte.setOnClickListener {
            val intent = Intent(this, H1::class.java)
            startActivity(intent)
            finishAffinity()}
        adopcion.setOnClickListener {
            val intent = Intent(this, G1::class.java)
            startActivity(intent)
            finishAffinity()}
        rescate.setOnClickListener {
            val intent = Intent(this, F1::class.java)
            startActivity(intent)
            finishAffinity()}
        historial.setOnClickListener {
            val intent = Intent(this, D1::class.java)
            startActivity(intent)
            finishAffinity()}
        cuenta.setOnClickListener {
            val intent = Intent(this, E1::class.java)
            startActivity(intent)
            finishAffinity()}
        emer.setOnClickListener {
            val intent = Intent(this, I1::class.java)
            startActivity(intent)
            finishAffinity()}
    }
}