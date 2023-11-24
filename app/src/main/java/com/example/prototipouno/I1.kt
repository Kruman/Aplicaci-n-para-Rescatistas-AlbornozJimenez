package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.net.Uri

class I1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i1)


        val inicio = findViewById<ImageButton>(R.id.ini)
        val emeregencia = findViewById<ImageButton>(R.id.nueveonce)
        val fundacion = findViewById<ImageButton>(R.id.funda)

        fun llamar911(){
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }

        fun llamarFunda(){
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }
        emeregencia.setOnClickListener {
            llamar911()
            }
        fundacion.setOnClickListener {
            llamarFunda()
        }


        inicio.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()}
    }
}