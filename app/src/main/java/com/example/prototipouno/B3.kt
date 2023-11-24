package com.example.prototipouno

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class B3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b3)

        val continuar=findViewById<Button>(R.id.vercod)
        val codigo=findViewById<EditText>(R.id.cod)
        val error = findViewById<TextView>(R.id.coderror)
        val usuario = intent.getStringExtra("DATO1")
        val cod = intent.getStringExtra("COD")

        var registro = ""
        if (usuario != null) {
            registro = usuario
        }
        var con = ""
        if (cod != null) {
            con = cod
        }
        val array = registro.split(",").toTypedArray()
        val nombre = array[0]
        val apellidos = array[1]
        val rfc =array[2]
        val direccion =array[3]
        val telefono =array[4]
        val correo = array[5]
        val contra =array[6]

       continuar.setOnClickListener(){
            var codi =codigo.text.toString()
            if (codi =="1234") {
                val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
                val db = dbHandler.writableDatabase
                val values = ContentValues()
                values.put("nombre", nombre)
                values.put("apellido", apellidos)
                values.put("rfc", rfc)
                values.put("domicilio", direccion)
                values.put("telefono", telefono)
                values.put("correo", correo)
                values.put("contraseña", contra)
                db.insert("usuarios", null, values)
                db.close()

            val intent = Intent(this, B4::class.java)
            startActivity(intent)
            finishAffinity()
            }else{error.setText("Codigo incorrecto")}
        }
    }
}