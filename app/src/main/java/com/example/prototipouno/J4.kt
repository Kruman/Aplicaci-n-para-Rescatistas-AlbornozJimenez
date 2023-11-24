package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class J4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j4)

        val inicio = findViewById<ImageButton>(R.id.ret)

        inicio.setOnClickListener {
            val intent = Intent(this, J1::class.java)
            startActivity(intent)
            finishAffinity()}
    }

}