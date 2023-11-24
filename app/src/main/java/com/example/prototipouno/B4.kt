package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class B4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b4)

        val entrar = findViewById<Button>(R.id.entrar)



        entrar.setOnClickListener {
                val intent = Intent(this, C1::class.java)
                startActivity(intent)
                finishAffinity()
            }

    }
    }
