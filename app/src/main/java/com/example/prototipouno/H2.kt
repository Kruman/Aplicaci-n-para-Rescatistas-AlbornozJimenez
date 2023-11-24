package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Date
import java.text.SimpleDateFormat

class H2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h2)


        val continuar = findViewById<Button>(R.id.conti)
        var reporte = intent.getStringExtra("DATO1")

       var rp = reporte
        continuar.setOnClickListener {
            val intent = Intent(this, H3::class.java)
            intent.putExtra("DATO1", rp)
            startActivity(intent)
            finishAffinity()
        }
    }
}