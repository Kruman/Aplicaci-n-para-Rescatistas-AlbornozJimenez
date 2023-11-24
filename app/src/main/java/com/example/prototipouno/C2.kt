package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.os.Process
import android.os.Process.killProcess

class C2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c2)

        var usuarios = findViewById<Button>(R.id.vusu)
        var solicitud = findViewById<Button>(R.id.vsol)
        var rescate = findViewById<Button>(R.id.vres)
        var reporte = findViewById<Button>(R.id.vrep)
        var eliminar = findViewById<Button>(R.id.elusu)
        var limpiar = findViewById<Button>(R.id.limpiar)
        var terminar = findViewById<Button>(R.id.cerrar)

        reporte.setOnClickListener {
            val intent = Intent(this, C3::class.java)
            intent.putExtra("DATO1", "reporte")
            startActivity(intent)
            finishAffinity()}
        solicitud.setOnClickListener {
            val intent = Intent(this, C3::class.java)
            intent.putExtra("DATO1", "solicitud")
            startActivity(intent)
            finishAffinity()}
        rescate.setOnClickListener {
            val intent = Intent(this, C3::class.java)
            intent.putExtra("DATO1", "rescate")
            startActivity(intent)
            finishAffinity()}
        usuarios.setOnClickListener {
            val intent = Intent(this, C3::class.java)
            intent.putExtra("DATO1", "usuarios")
            startActivity(intent)
            finishAffinity()}
        eliminar.setOnClickListener {
            val intent = Intent(this, C2::class.java)
            startActivity(intent)
            finishAffinity()}
        limpiar.setOnClickListener {
            val intent = Intent(this, C2::class.java)
            startActivity(intent)
            finishAffinity()}
        terminar.setOnClickListener {
            // Finaliza la actividad actual
            finish()
            // Finaliza el proceso de la aplicación
            Process.killProcess(Process.myPid())
        }
    }
}