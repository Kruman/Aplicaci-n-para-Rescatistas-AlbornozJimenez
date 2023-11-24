package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class E2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e2)
        val inicio = findViewById<ImageButton>(R.id.volver)

        inicio.setOnClickListener {
            val intent = Intent(this, E1::class.java)
            startActivity(intent)
            finishAffinity()}
    }
}