package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class J1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j1)

        val regresa = findViewById<ImageButton>(R.id.regresa)
        val contra = findViewById<ImageButton>(R.id.CambContraseña)
        val correo = findViewById<ImageButton>(R.id.CamCorreo)
        val numero = findViewById<ImageButton>(R.id.CambNum)
        val CS = findViewById<ImageButton>(R.id.CerrarSecion)
        val historial = findViewById<ImageButton>(R.id.historial)
        val cuenta = findViewById<ImageButton>(R.id.datos)
        val inicio = findViewById<ImageButton>(R.id.init)

        regresa.setOnClickListener {
            val intent = Intent(this, E1::class.java)
            startActivity(intent)
            finishAffinity()}
        contra.setOnClickListener {
            val intent = Intent(this, J2::class.java)
            startActivity(intent)
            finishAffinity()}
        correo.setOnClickListener {
            val intent = Intent(this, J3::class.java)
            startActivity(intent)
            finishAffinity()}
        numero.setOnClickListener {
            val intent = Intent(this, J4::class.java)
            startActivity(intent)
            finishAffinity()}
        CS.setOnClickListener {
            val intent = Intent(this, J5::class.java)
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
        inicio.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()}
    }

}