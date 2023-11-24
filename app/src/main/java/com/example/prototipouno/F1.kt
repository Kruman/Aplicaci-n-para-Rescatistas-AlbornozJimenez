package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView

class F1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f1)

        val aceptar = findViewById<Button>(R.id.sig)
        val regresar = findViewById<ImageButton>(R.id.menu)
        val tipo = findViewById<EditText>(R.id.R1)
        val com = findViewById<EditText>(R.id.R2)
        val estado = findViewById<EditText>(R.id.R3)
        val obv = findViewById<EditText>(R.id.R4)
        val mal = findViewById<TextView>(R.id.aler)
        val radioGroup = findViewById<RadioGroup>(R.id.RG)

        var D5=""
        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
            when (checkedId) {
                R.id.M -> { D5="Macho" }
                R.id.H -> { D5="Hembra" }
            }
        }

        aceptar.setOnClickListener {
            var D1 = tipo.text.toString()
            var D2 = com.text.toString()
            var D3 = estado.text.toString()
            var D4 = obv.text.toString()

            if(D1 != "" && D2 != ""&& D3 != ""&& D4 != ""&& D5 != ""){
                var rescate = D1+","+D2+","+D3+","+D4+","+D5
                val intent = Intent(this, F2::class.java)
                intent.putExtra("RES", rescate)
                startActivity(intent)
                finishAffinity()
            }
            else{ mal.setText("Llene todos los campos ")}
        }

        regresar.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}