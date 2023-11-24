package com.example.prototipouno

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.prototipouno.databinding.ActivityH3Binding
import com.google.android.material.snackbar.Snackbar
import com.itextpdf.text.BaseColor
import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Font
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class H3 : AppCompatActivity() {

    lateinit var binding: ActivityH3Binding
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {

            isAceptado ->
        if (isAceptado) Toast.makeText(this,"PDF",Toast.LENGTH_SHORT).show()
        else Toast.makeText(this,"PDF ERROR",Toast.LENGTH_SHORT).show()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_h3)
        binding = ActivityH3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val cancelar :Button = binding.cancel
        val aceptar: Button = binding.fin
        val final :TextView= binding.reportefinal
        val reporte = intent.getStringExtra("DATO1")
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val fechaActual = dateFormat.format(Date())
        val calendar = Calendar.getInstance()
        val formatoHora = SimpleDateFormat("HH:mm:ss")
        val horaExacta = formatoHora.format(calendar.time)

        var flag =0

        fun crearPDF(texto: String,nombre: String){
            try {
                val carpeta  ="/Albornoz"
                val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath+carpeta
                val dir = File(path)
                if(!dir.exists()){
                    dir.mkdirs()
                    Toast.makeText(this,"CARPETA CREADA",Toast.LENGTH_SHORT).show()
                }
                val archivo = File(dir,nombre+".pdf")
                val fos = FileOutputStream(archivo)
                val documento = Document()
                PdfWriter.getInstance(documento, fos)
                documento.open()
                val titulo = Paragraph("Reporte", FontFactory.getFont("arial",34f, Font.BOLD, BaseColor.BLACK))
                val contenido = Paragraph(texto)
                documento.add(titulo)
                documento.add(contenido)
                documento.close()
            }catch(e: FileNotFoundException){
                e.printStackTrace()
            }catch(e: DocumentException){
            }
        }
        fun verificarPermisos(view: View? = null) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Permisoso Concedidos", Toast.LENGTH_SHORT).show()
                    flag = 1
                }
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) -> {
                    // Verificar si `view` es nulo antes de usarlo
                    view?.let {
                        Snackbar.make(it, "ESTE PERMISO ES NECESARIO PARA CREAR EL ARCHIVO", Snackbar.LENGTH_INDEFINITE)
                            .setAction("OK") {
                                requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            }.show()
                    }
                }
                else -> {
                    requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }
        }

        verificarPermisos()

        var registro = ""
        if (reporte != null) {
            registro = reporte
        }
        val array = registro.split(",").toTypedArray()
        val especie = array[0]
        val caracteristicas = array[1]
        val condiciones =array[2]
        val acciones =array[3]
        val otros =array[4]
        val lugar = "Ciudad de Mexico"

        var texto ="Especie del Animal:"+ especie+"\n"+"\n"
        texto = texto+"Caracteristicas:"+caracteristicas+"\n"+"\n"
        texto = texto+"Condiciones en las que se encontro:"+condiciones+"\n"+"\n"
        texto = texto+"Aciones tomadas hasta el momento:"+acciones+"\n"+"\n"
        texto = texto+"Recomendaciones o sugerencias:"+otros+"\n"+"\n"
        texto = texto+"Lugar:"+lugar+"\n"+"\n"
        texto = texto+"Fecha:"+fechaActual+"\n"+"\n"
        texto = texto+"Hora:"+horaExacta+"\n"+"\n"

        final.setText(texto)


        cancelar.setOnClickListener {
            val intent = Intent(this, C1::class.java)
            startActivity(intent)
            finishAffinity()
        }
        aceptar.setOnClickListener {
            val dbHandler = AdminSQLiteOpenHelper(this, "rescatistas", null, 2)
            val db = dbHandler.writableDatabase
            val values = ContentValues()
            values.put("especie", especie)
            values.put("caracteristicas", caracteristicas)
            values.put("condiciones", condiciones)
            values.put("lugar", lugar)
            values.put("acciones", acciones)
            values.put("otros", otros)
            values.put("fecha", fechaActual)
            values.put("hora", horaExacta)
            db.insert("reportes", null, values)
            db.close()
            var nombre = "REPORTE-"+fechaActual+horaExacta
            if(flag == 1){ crearPDF(texto,nombre)}

            val intent = Intent(this, C1::class.java)
            //Toast.makeText(this, "Reporte guardado", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finishAffinity()
        }
    }


}