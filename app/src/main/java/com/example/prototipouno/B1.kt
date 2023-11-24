package com.example.prototipouno

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.util.Log

class B1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)
        val entrar = findViewById<Button>(R.id.entrar)
        val registrarse = findViewById<Button>(R.id.registrarse)
        val name = findViewById<EditText>(R.id.name)
        val pass = findViewById<EditText>(R.id.pass)
        val mal = findViewById<TextView>(R.id.inco)

         fun verificarCredenciales(correo: String, contraseña: String): Boolean {
             val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
             val db = dbHandler.readableDatabase
             val columns = arrayOf("correo", "contraseña")
             val selection = "correo = ? AND contraseña = ?"
             val selectionArgs = arrayOf(correo, contraseña)
             val cursor: Cursor = db.query("usuarios", columns, selection, selectionArgs, null, null, null)
             Log.d("AQUIII", cursor.toString())
             val existeUsuario = cursor.count > 0

             cursor.close()
             db.close()

             return existeUsuario
         }

        var nombre = ""
        var password = ""
        var bandera2 = 0

        entrar.setOnClickListener {
            nombre = name.text.toString()
            password = pass.text.toString()
            if (nombre == "AlbornozJimenez" && password == "ContraseñaSecreta1234") {
                val intent = Intent(this, C2::class.java)
                startActivity(intent)
                finishAffinity()
            } else {
                val esCredencialValida = verificarCredenciales(nombre, password)
                if (nombre != null && nombre != "") {
                } else {
                    Toast.makeText(this, "Escribe un nombre", Toast.LENGTH_LONG).show()
                }

                if (password != null && password != "") {
                    if (nombre == "admin" || esCredencialValida == true) {
                        bandera2 = 1
                    } else {
                        Toast.makeText(this, "Datos invalidos", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Escribe una contraseña", Toast.LENGTH_LONG).show()
                }

                if (bandera2 == 1) {

                    mal.setText("")
                    val intent = Intent(this, C1::class.java)
                    startActivity(intent)
                    finishAffinity()
                } else {
                    mal.setText("Datos incorrectos")
                }
            }
        }
        registrarse.setOnClickListener {
            val intent = Intent(this, B2::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}