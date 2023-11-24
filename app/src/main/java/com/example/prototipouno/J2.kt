package com.example.prototipouno


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton

class J2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j2)
        val inicio = findViewById<ImageButton>(R.id.regresa)


        inicio.setOnClickListener {
            val intent = Intent(this, J1::class.java)
            startActivity(intent)
            finishAffinity()}
    }

}