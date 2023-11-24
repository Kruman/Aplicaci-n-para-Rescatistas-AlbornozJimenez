package com.example.prototipouno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar

class A1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a1)
        lateinit var progressBar: ProgressBar
        progressBar = findViewById(R.id.pro)

        val timer = object: CountDownTimer(3000, 100) {

            override fun onTick(millisUntilFinished: Long) {
                val progress = ((3000 - millisUntilFinished) / 30).toInt()
                progressBar.progress = progress
            }

            override fun onFinish() {
                val intent = Intent(this@A1, B1::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }

        timer.start()
    }
}
