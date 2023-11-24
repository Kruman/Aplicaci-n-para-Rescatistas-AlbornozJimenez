package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class J5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j5)
        val inicio = findViewById<ImageButton>(R.id.reto)

        inicio.setOnClickListener {
            val intent = Intent(this, J1::class.java)
            startActivity(intent)
            finishAffinity()}
    }
}