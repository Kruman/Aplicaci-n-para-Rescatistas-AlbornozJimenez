package com.example.prototipouno

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity



class F2 : AppCompatActivity() {
    private lateinit var visor: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f2)


        val rescate = intent.getStringExtra("RES")
        val continuar = findViewById<Button>(R.id.capt)
        val cancelar = findViewById<ImageButton>(R.id.can)

        val captura = findViewById<Button>(R.id.btn)
        visor = findViewById<ImageView>(R.id.iv_visor)
        captura.setOnClickListener {
            camara()
        }

        continuar.setOnClickListener {
            val intent = Intent(this, F3::class.java)
            intent.putExtra("RES", rescate)
            startActivity(intent)
            finishAffinity()
        }

        cancelar.setOnClickListener {
            val intent = Intent(this, F1::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

    fun camara() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val extras = data?.extras
            val imgBitmap = extras?.get("data") as Bitmap
            visor.setImageBitmap(imgBitmap)
        }
    }
}