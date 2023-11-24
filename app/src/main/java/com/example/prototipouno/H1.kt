package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class H1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h1)


        val regresar = findViewById<ImageButton>(R.id.regresa)
        val aceptar = findViewById<Button>(R.id.acep)
        val detalles = findViewById<EditText>(R.id.dat1)
        val infoAn = findViewById<EditText>(R.id.dat2)
        val infoAd = findViewById<EditText>(R.id.dat3)
        val acciones = findViewById<EditText>(R.id.dat4)
        val recomendacion = findViewById<EditText>(R.id.dat5)
        val mal = findViewById<TextView>(R.id.alerta)



        regresar.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()
        }

        aceptar.setOnClickListener {

            var D1 = detalles.text.toString()
            var D2 = infoAn.text.toString()
            var D3 = infoAd.text.toString()
            var D4 = acciones.text.toString()
            var D5 = recomendacion.text.toString()

            if(D1 != "" && D2 != ""&& D3 != ""&& D4 != ""&& D5 != ""){
                var reporte = D1+","+D2+","+D3+","+D4+","+D5
                val intent = Intent(this, H2::class.java)
                intent.putExtra("DATO1", reporte)
                startActivity(intent)
                finishAffinity()
            }
            else{ mal.setText("Llene todos los campos ")}

        }
    }
}