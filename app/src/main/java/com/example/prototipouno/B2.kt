package com.example.prototipouno

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class B2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b2)

        val cancel=findViewById<ImageButton>(R.id.regresa)
        val registro=findViewById<Button>(R.id.registro)

        val name=findViewById<EditText>(R.id.info)
        val apellido=findViewById<EditText>(R.id.info1)
        val rfc=findViewById<EditText>(R.id.info2)
        val direcion=findViewById<EditText>(R.id.info3)
        val tele=findViewById<EditText>(R.id.info4)
        val correo=findViewById<EditText>(R.id.info5)
        val pass=findViewById<EditText>(R.id.info6)
        val pass2=findViewById<EditText>(R.id.info7)

        val aler=findViewById<TextView>(R.id.al)
        val aler1=findViewById<TextView>(R.id.al1)
        val aler2=findViewById<TextView>(R.id.al2)
        val aler3=findViewById<TextView>(R.id.al3)
        val aler4=findViewById<TextView>(R.id.al4)
        val aler5=findViewById<TextView>(R.id.al5)
        val aler6=findViewById<TextView>(R.id.al6)
        val aler7=findViewById<TextView>(R.id.al7)


        fun nombre(input: String): Boolean {
            val regex = Regex("^[A-Z][a-z]+(?: [A-Z][a-z]+){0,2}\$")
            val matches = regex.matches(input)
            if (matches) {
                Log.i("Pattern", "Coincide: $input")
            } else {
                Log.e("Pattern", "No coincide: $input")
            }
            return regex.matches(input)
        }
        fun RFC(input: String): Boolean {
            val regex = Regex("^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}\$")
            val matches = regex.matches(input)
            if (matches) {
                Log.i("Pattern", "Coincide: $input")
            } else {
                Log.e("Pattern", "No coincide: $input")
            }
            return regex.matches(input)
        }

        fun DIR(input: String): Boolean {
            val regex = Regex("^[a-zA-Z0-9,.'\\- ]+\$")
            val matches = regex.matches(input)
            if (matches) {
                Log.i("Pattern", "Coincide: $input")
            } else {
                Log.e("Pattern", "No coincide: $input")
            }
            return regex.matches(input)
        }
        fun Email(input: String): Boolean {
            val regex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
            val matches = regex.matches(input)
            if (matches) {
                Log.i("Pattern", "Coincide: $input")
            } else {
                Log.e("Pattern", "No coincide: $input")
            }
            return regex.matches(input)
        }
        fun contras(input: String): Boolean {
            val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$")
            val matches = regex.matches(input)
            if (matches) {
                Log.i("Pattern", "Coincide: $input")
            } else {
                Log.e("Pattern", "No coincide: $input")
            }
            return regex.matches(input)
        }
        registro.setOnClickListener(){
            var flag=0

            var nom=name.text.toString()
            var ape=apellido.text.toString()
            var rfc2=rfc.text.toString()
            var direc=direcion.text.toString()
            var tel=tele.text.toString()
            var cor=correo.text.toString()
            var contra=pass.text.toString()
            var contra2=pass2.text.toString()


            if(nombre(nom)){
                flag+=1
                aler.setText("")
            }else{aler.setText("Nombre invalido")}

            if(nombre(ape)){
                flag+=1
                aler1.setText("")
            }else{aler1.setText("Apellido invalido")}

            if(RFC(rfc2)){
                flag+=1
                aler2.setText("")
            }else{aler2.setText("RFC invalido")}

            if(DIR(direc)){
                flag+=1
                aler2.setText("")
            }else{aler3.setText("Direccion invalida")}

            val longitud = tel.length
            if(longitud==10){
                flag+=1
                aler2.setText("")
            }else{aler4.setText("Telefono invalido")}

            if(Email(cor)){
                flag+=1
                aler2.setText("")
            }else{aler5.setText("Correo invalido")}

            if(contras(contra)){
                flag+=1
                aler2.setText("")
            }else{aler6.setText("Contraseña invalida")}

            if(contra2==contra){
                flag+=1
                aler2.setText("")
            }else{aler7.setText("Contraseña incorrecta")}

                 var usuario =
                    nom + "," + ape + "," + rfc2 + "," + direc + "," + tel + "," + cor + "," + contra
                val intent = Intent(this, B3::class.java)
              //  intent.putExtra("COD", cod)
                intent.putExtra("DATO1", usuario)
                startActivity(intent)
                finishAffinity()
            }
            cancel.setOnClickListener() {
                val intent = Intent(this, B1::class.java)
                startActivity(intent)
            }
        }
    }
