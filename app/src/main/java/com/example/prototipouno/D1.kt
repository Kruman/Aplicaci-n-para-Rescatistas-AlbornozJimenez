package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date

class D1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d1)

        val menu = findViewById<ImageButton>(R.id.inicio)
        val usuario = findViewById<ImageButton>(R.id.datos)
        val historial = findViewById<TextView>(R.id.Historial)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val fechaActual = dateFormat.format(Date())


        data class Reportes(val Hora: String, val Fecha: String, val Especie: String, val Caracteristicas: String, val Condiciones: String, val Lugar: String, val Acciones: String)
        fun ID_reportes(fecha: String): List<Reportes> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Reportes>()
            val query = "SELECT * FROM reportes WHERE fecha = ?"
            val selectionArgs = arrayOf(fecha)
            val cursor = db.rawQuery(query, selectionArgs)

            if (cursor != null && cursor.moveToFirst()) {
                val horaColumnIndex = cursor.getColumnIndex("hora")
                val fechaColumnIndex = cursor.getColumnIndex("fecha")
                val tipoColumnIndex = cursor.getColumnIndex("especie")
                val comportamientoColumnIndex = cursor.getColumnIndex("caracteristicas")
                val estadoColumnIndex = cursor.getColumnIndex("condiciones")
                val observacionColumnIndex = cursor.getColumnIndex("lugar")
                val generoColumnIndex = cursor.getColumnIndex("acciones")

                if (horaColumnIndex > -1) {
                    do {
                        val hora = cursor.getString(horaColumnIndex)
                        val fecha = cursor.getString(fechaColumnIndex)
                        val tipo = cursor.getString(tipoColumnIndex)
                        val comportamiento = cursor.getString(comportamientoColumnIndex)
                        val estado = cursor.getString(estadoColumnIndex)
                        val observacion = cursor.getString(observacionColumnIndex)
                        val genero = cursor.getString(generoColumnIndex)

                        val rescate = Reportes(hora, fecha, tipo, comportamiento, estado, observacion, genero)
                        rescates.add(rescate)
                    } while (cursor.moveToNext())
                }
                cursor.close()
            }
            db.close()
            return rescates
        }
            data class Solicitud(val Hora: String, val Fecha: String, val Nombre: String, val Direcion: String, val Telefono: String, val Correo: String, val Experiencia: String)
            fun ID_solicitud(fecha: String): List<Solicitud> {
                val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
                val db = dbHandler.readableDatabase
                val rescates = mutableListOf<Solicitud>()
                val query = "SELECT * FROM solicitud WHERE fecha = ?"
                val selectionArgs = arrayOf(fecha)
                val cursor = db.rawQuery(query, selectionArgs)

                if (cursor != null && cursor.moveToFirst()) {
                    val horaColumnIndex = cursor.getColumnIndex("hora")
                    val fechaColumnIndex = cursor.getColumnIndex("fecha")
                    val tipoColumnIndex = cursor.getColumnIndex("nombre")
                    val comportamientoColumnIndex = cursor.getColumnIndex("direccion")
                    val estadoColumnIndex = cursor.getColumnIndex("telefono")
                    val observacionColumnIndex = cursor.getColumnIndex("correo")
                    val generoColumnIndex = cursor.getColumnIndex("experiencia")

                    if (horaColumnIndex > -1) {
                        do {
                            val hora = cursor.getString(horaColumnIndex)
                            val fecha = cursor.getString(fechaColumnIndex)
                            val tipo = cursor.getString(tipoColumnIndex)
                            val comportamiento = cursor.getString(comportamientoColumnIndex)
                            val estado = cursor.getString(estadoColumnIndex)
                            val observacion = cursor.getString(observacionColumnIndex)
                            val genero = cursor.getString(generoColumnIndex)

                            val rescate = Solicitud(hora, fecha, tipo, comportamiento, estado, observacion, genero)
                            rescates.add(rescate)
                        } while (cursor.moveToNext())
                    }
                    cursor.close()
                }
                db.close()
                return rescates
            }

        data class Rescate(val Hora: String, val Fecha: String, val Tipo: String, val Comportamiento: String, val Estado: String, val Observacion: String, val Genero: String)
        fun ID_rescate(fecha: String): List<Rescate> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Rescate>()
            val query = "SELECT * FROM rescate WHERE fecha = ?"
            val selectionArgs = arrayOf(fecha)
            val cursor = db.rawQuery(query, selectionArgs)

            if (cursor != null && cursor.moveToFirst()) {
                val horaColumnIndex = cursor.getColumnIndex("hora")
                val fechaColumnIndex = cursor.getColumnIndex("fecha")
                val tipoColumnIndex = cursor.getColumnIndex("tipo")
                val comportamientoColumnIndex = cursor.getColumnIndex("comportamiento")
                val estadoColumnIndex = cursor.getColumnIndex("estado")
                val observacionColumnIndex = cursor.getColumnIndex("observacion")
                val generoColumnIndex = cursor.getColumnIndex("genero")

                if (horaColumnIndex > -1) {
                    do {
                        val hora = cursor.getString(horaColumnIndex)
                        val fecha = cursor.getString(fechaColumnIndex)
                        val tipo = cursor.getString(tipoColumnIndex)
                        val comportamiento = cursor.getString(comportamientoColumnIndex)
                        val estado = cursor.getString(estadoColumnIndex)
                        val observacion = cursor.getString(observacionColumnIndex)
                        val genero = cursor.getString(generoColumnIndex)

                        val rescate = Rescate(hora, fecha, tipo, comportamiento, estado, observacion, genero)
                        rescates.add(rescate)
                    } while (cursor.moveToNext())
                }
                cursor.close()
            }
            db.close()
            return rescates
        }
        var texto=""
        val report=ID_reportes(fechaActual)
        val sol=ID_solicitud(fechaActual)
        val rescat=ID_rescate(fechaActual)

        for (elemento in report) {
            texto+=""+elemento+"\n"+"\n"
        }
        for (elemento in sol) {
              texto+=""+elemento+"\n"+"\n"
          }
        for (elemento in rescat) {
             texto+=""+elemento+"\n"+"\n"
         }
        historial.setText(texto)

        menu.setOnClickListener(){
            val intent = Intent(this, C1::class.java)

            startActivity(intent)
            finishAffinity()
        }
        usuario.setOnClickListener(){
            val intent = Intent(this, E1::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}