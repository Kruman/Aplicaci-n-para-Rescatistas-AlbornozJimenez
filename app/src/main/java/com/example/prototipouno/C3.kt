package com.example.prototipouno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class C3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c3)
        var dato = intent.getStringExtra("DATO1")
        var titulo = findViewById<TextView>(R.id.titulo)
        var informacion = findViewById<TextView>(R.id.infoss)

        data class Reportes(val Hora: String, val Fecha: String, val Especie: String, val Caracteristicas: String, val Condiciones: String, val Lugar: String, val Acciones: String)
        fun obtenerTodosReportes(): List<Reportes> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Reportes>()

            try {
                val query = "SELECT * FROM reportes"
                val cursor = db.rawQuery(query, null)

                if (cursor != null && cursor.moveToFirst()) {
                    val horaColumnIndex = cursor.getColumnIndexOrThrow("hora")
                    val fechaColumnIndex = cursor.getColumnIndexOrThrow("fecha")
                    val tipoColumnIndex = cursor.getColumnIndexOrThrow("especie")
                    val comportamientoColumnIndex = cursor.getColumnIndexOrThrow("caracteristicas")
                    val estadoColumnIndex = cursor.getColumnIndexOrThrow("condiciones")
                    val observacionColumnIndex = cursor.getColumnIndexOrThrow("lugar")
                    val generoColumnIndex = cursor.getColumnIndexOrThrow("acciones")

                    do {
                        val hora = cursor.getString(horaColumnIndex)
                        val fecha = cursor.getString(fechaColumnIndex)
                        val especie = cursor.getString(tipoColumnIndex)
                        val caracteristicas = cursor.getString(comportamientoColumnIndex)
                        val condiciones = cursor.getString(estadoColumnIndex)
                        val lugar = cursor.getString(observacionColumnIndex)
                        val acciones = cursor.getString(generoColumnIndex)

                        val reporte = Reportes(hora, fecha, especie, caracteristicas, condiciones, lugar, acciones)
                        rescates.add(reporte)
                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                // Manejo de excepciones
            } finally {
                db.close()
            }

            return rescates
        }
        data class Solicitud(val Hora: String, val Fecha: String, val Nombre: String, val Direcion: String, val Telefono: String, val Correo: String, val Experiencia: String)
        fun obtenerTodasSolicitudes(): List<Solicitud> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Solicitud>()

            try {
                val query = "SELECT * FROM solicitud"
                val cursor = db.rawQuery(query, null)

                if (cursor != null && cursor.moveToFirst()) {
                    val horaColumnIndex = cursor.getColumnIndexOrThrow("hora")
                    val fechaColumnIndex = cursor.getColumnIndexOrThrow("fecha")
                    val tipoColumnIndex = cursor.getColumnIndexOrThrow("nombre")
                    val comportamientoColumnIndex = cursor.getColumnIndexOrThrow("direccion")
                    val estadoColumnIndex = cursor.getColumnIndexOrThrow("telefono")
                    val observacionColumnIndex = cursor.getColumnIndexOrThrow("correo")
                    val generoColumnIndex = cursor.getColumnIndexOrThrow("experiencia")

                    do {
                        val hora = cursor.getString(horaColumnIndex)
                        val fecha = cursor.getString(fechaColumnIndex)
                        val nombre = cursor.getString(tipoColumnIndex)
                        val direccion = cursor.getString(comportamientoColumnIndex)
                        val telefono = cursor.getString(estadoColumnIndex)
                        val correo = cursor.getString(observacionColumnIndex)
                        val experiencia = cursor.getString(generoColumnIndex)

                        val solicitud = Solicitud(hora, fecha, nombre, direccion, telefono, correo, experiencia)
                        rescates.add(solicitud)
                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                // Manejo de excepciones
            } finally {
                db.close()
            }

            return rescates
        }

        data class Rescate(val Hora: String, val Fecha: String, val Tipo: String, val Comportamiento: String, val Estado: String, val Observacion: String, val Genero: String)
        fun obtenerTodosRescates(): List<Rescate> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val rescates = mutableListOf<Rescate>()

            try {
                val query = "SELECT * FROM rescate"
                val cursor = db.rawQuery(query, null)

                if (cursor != null && cursor.moveToFirst()) {
                    val horaColumnIndex = cursor.getColumnIndexOrThrow("hora")
                    val fechaColumnIndex = cursor.getColumnIndexOrThrow("fecha")
                    val tipoColumnIndex = cursor.getColumnIndexOrThrow("tipo")
                    val comportamientoColumnIndex = cursor.getColumnIndexOrThrow("comportamiento")
                    val estadoColumnIndex = cursor.getColumnIndexOrThrow("estado")
                    val observacionColumnIndex = cursor.getColumnIndexOrThrow("observacion")
                    val generoColumnIndex = cursor.getColumnIndexOrThrow("genero")

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
            } catch (e: Exception) {
                // Manejo de excepciones
            } finally {
                db.close()
            }

            return rescates
        }
        data class Usuario(val Nombre: String, val Apellido: String, val RFC: String, val Domicilio: String, val Telefono: String, val Correo: String)
        fun obtenerTodosUsuarios(): List<Usuario> {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.readableDatabase
            val usuarioss = mutableListOf<Usuario>()

            try {
                val query = "SELECT * FROM usuarios"
                val cursor = db.rawQuery(query, null)

                if (cursor != null && cursor.moveToFirst()) {
                    val nombreColumnIndex = cursor.getColumnIndexOrThrow("nombre")
                    val apellidoColumnIndex = cursor.getColumnIndexOrThrow("apellido")
                    val rfcColumnIndex = cursor.getColumnIndexOrThrow("rfc")
                    val domicilioColumnIndex = cursor.getColumnIndexOrThrow("domicilio")
                    val telefonoColumnIndex = cursor.getColumnIndexOrThrow("telefono")
                    val correoColumnIndex = cursor.getColumnIndexOrThrow("correo")


                    do {
                        val nombre = cursor.getString(nombreColumnIndex)
                        val apellido = cursor.getString(apellidoColumnIndex)
                        val rfc = cursor.getString(rfcColumnIndex)
                        val domicilio = cursor.getString(domicilioColumnIndex)
                        val telefono = cursor.getString(telefonoColumnIndex)
                        val correo = cursor.getString(correoColumnIndex)


                        val usuarios = Usuario(nombre, apellido, rfc, domicilio, telefono, correo)
                        usuarioss.add(usuarios)
                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                // Manejo de excepciones
            } finally {
                db.close()
            }

            return usuarioss
        }
        fun mostrarRescatesEnTextView(textView: TextView) {
            val rescates = obtenerTodosRescates()

            if (rescates.isNotEmpty()) {
                val textoRescates = StringBuilder()

                for (rescate in rescates) {
                    textoRescates.append("Hora: ${rescate.Hora}\n")
                    textoRescates.append("Fecha: ${rescate.Fecha}\n")
                    textoRescates.append("Tipo: ${rescate.Tipo}\n")
                    textoRescates.append("Comportamiento: ${rescate.Comportamiento}\n")
                    textoRescates.append("Estado: ${rescate.Estado}\n")
                    textoRescates.append("Observacion: ${rescate.Observacion}\n")
                    textoRescates.append("Genero: ${rescate.Genero}\n\n")
                }

                textView.text = textoRescates.toString()
            } else {
                textView.text = "No hay datos de rescates disponibles."
            }
        }
        fun mostrarReportesEnTextView(textView: TextView) {
            val reportes = obtenerTodosReportes()

            if (reportes.isNotEmpty()) {
                val textoReportes = StringBuilder()

                for (report in reportes) {
                    textoReportes.append("Hora: ${report.Hora}\n")
                    textoReportes.append("Fecha: ${report.Fecha}\n")
                    textoReportes.append("Especie: ${report.Especie}\n")
                    textoReportes.append("Caracteristicas: ${report.Caracteristicas}\n")
                    textoReportes.append("Condiciones: ${report.Condiciones}\n")
                    textoReportes.append("Lugar: ${report.Lugar}\n")
                    textoReportes.append("Acciones: ${report.Acciones}\n\n")
                }

                textView.text = textoReportes.toString()
            } else {
                textView.text = "No hay datos de reportes disponibles."
            }
        }
        fun mostrarSolicitudesEnTextView(textView: TextView) {
            val solicitudes = obtenerTodasSolicitudes()

            if (solicitudes.isNotEmpty()) {
                val textoSolicitud = StringBuilder()

                for (sol in solicitudes) {
                    textoSolicitud.append("Hora: ${sol.Hora}\n")
                    textoSolicitud.append("Fecha: ${sol.Fecha}\n")
                    textoSolicitud.append("Nombre: ${sol.Nombre}\n")
                    textoSolicitud.append("Direccion: ${sol.Direcion}\n")
                    textoSolicitud.append("Telefono: ${sol.Telefono}\n")
                    textoSolicitud.append("Correo: ${sol.Correo}\n")
                    textoSolicitud.append("Experiencia: ${sol.Experiencia}\n\n")
                }

                textView.text = textoSolicitud.toString()
            } else {
                textView.text = "No hay datos de solicitudes disponibles."
            }
        }
        fun mostrarUsuariosEnTextView(textView: TextView) {
            val users = obtenerTodosUsuarios()

            if (users.isNotEmpty()) {
                val textoUsuarios = StringBuilder()

                for (us in users) {
                    textoUsuarios.append("nombre: ${us.Nombre}\n")
                    textoUsuarios.append("Apellido: ${us.Apellido}\n")
                    textoUsuarios.append("RFC: ${us.RFC}\n")
                    textoUsuarios.append("Domicilio: ${us.Domicilio}\n")
                    textoUsuarios.append("Telefono: ${us.Telefono}\n")
                    textoUsuarios.append("Correo: ${us.Correo}\n")

                }

                textView.text = textoUsuarios.toString()
            } else {
                textView.text = "No hay datos de usuarios disponibles."
            }
        }
        //ELECCION
        if(dato!=null){
            when {
                dato == "reporte" -> {titulo.setText("Visulización de Reportes")
                    mostrarReportesEnTextView(informacion)}
                dato == "solicitud" -> {titulo.setText("Visulización de Solicitudes")
                    mostrarSolicitudesEnTextView(informacion)}
                dato == "rescate" -> {titulo.setText("Visulización de Rescates")
                    mostrarRescatesEnTextView(informacion)}
                dato == "usuarios" -> {titulo.setText("Visulización de Usuarios")
                    mostrarUsuariosEnTextView(informacion)}
            }
        }
    }
}