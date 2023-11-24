package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class G1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g1)

        val regresar = findViewById<ImageButton>(R.id.regresa)
        val aceptar = findViewById<Button>(R.id.acep)
        val nom = findViewById<EditText>(R.id.dat1)
        val direc = findViewById<EditText>(R.id.dat2)
        val tel = findViewById<EditText>(R.id.dat3)
        val correo = findViewById<EditText>(R.id.dat4)
        val exp= findViewById<EditText>(R.id.dat5)
        val cumple = findViewById<EditText>(R.id.dat6)
        val adicional = findViewById<EditText>(R.id.dat7)
        val mal = findViewById<TextView>(R.id.flag)


        regresar.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()
        }

        aceptar.setOnClickListener {
            var D1 = nom.text.toString()
            var D2 = direc.text.toString()
            var D3 = tel.text.toString()
            var D4 = correo.text.toString()
            var D5 = exp.text.toString()
            var D6 = cumple.text.toString()
            var D7 = adicional.text.toString()

            if (D1 != "" && D2 != "" && D3 != "" && D4 != "" && D5 != ""&& D6 != ""&& D7 != "") {
                var reporte = D1 + "," + D2 + "," + D3 + "," + D4 + "," + D5+ "," + D6+ "," + D7
                val intent = Intent(this, G2::class.java)
                intent.putExtra("DATO1", reporte)
                startActivity(intent)
                finishAffinity()
            } else {
                mal.setText("Llene todos los campos ")
            }
        }
    }
}