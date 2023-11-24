package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class I2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i2)

        val informe=findViewById<TextView>(R.id.infos)
        val regresar=findViewById<Button>(R.id.BT)


        data class Usuario(val Nombre: String, val Apellido: String, val RFC: String, val Direcion: String, val Telefono: String, val Correo: String, val Contraseña: String)
        fun ID_usuario(fecha: String): List<Usuario> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Usuario>()
            val query = "SELECT * FROM usuarios WHERE correo = ?"
            val selectionArgs = arrayOf(fecha)
            val cursor = db.rawQuery(query, selectionArgs)

            if (cursor != null && cursor.moveToFirst()) {
                val horaColumnIndex = cursor.getColumnIndex("nombre")
                val fechaColumnIndex = cursor.getColumnIndex("apellido")
                val tipoColumnIndex = cursor.getColumnIndex("rfc")
                val comportamientoColumnIndex = cursor.getColumnIndex("domicilio")
                val estadoColumnIndex = cursor.getColumnIndex("telefono")
                val observacionColumnIndex = cursor.getColumnIndex("correo")
                val generoColumnIndex = cursor.getColumnIndex("contraseña")
                if (horaColumnIndex > -1) {
                    do {
                        val hora = cursor.getString(horaColumnIndex)
                        val fecha = cursor.getString(fechaColumnIndex)
                        val tipo = cursor.getString(tipoColumnIndex)
                        val comportamiento = cursor.getString(comportamientoColumnIndex)
                        val estado = cursor.getString(estadoColumnIndex)
                        val observacion = cursor.getString(observacionColumnIndex)
                        val genero = cursor.getString(generoColumnIndex)

                        val rescate = Usuario(hora, fecha, tipo, comportamiento, estado, observacion, "")
                        rescates.add(rescate)
                    } while (cursor.moveToNext())
                }
                cursor.close()
            }
            db.close()
            return rescates
        }

        val report=ID_usuario("ea.pz@outlook.com")

        informe.setText("Fundacón: Albornoz Jimenez "+"\n"+"\n"+"Sitios: https://vm.tiktok.com/ZMNNokJ47/ "+"\n"+"\n"+"Sitios: https://fundacionalbornozjimenez.com "+"\n"+"\n"+"Direccion: https://fundacionalbornozjimenez.com "+"\n"+"\n"+report)




        regresar.setOnClickListener() {
            val intent = Intent(this, J1::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}