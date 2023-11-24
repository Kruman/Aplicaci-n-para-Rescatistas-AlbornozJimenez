package com.example.prototipouno

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table reportes(ID_reportes integer primary key, especie text, caracteristicas text,condiciones text,lugar text,acciones text, otros text,fecha text, hora TEXT)")
        db.execSQL("create table solicitud(ID_solicitud integer primary key, nombre text,direccion text, telefono TEXT,correo text, experiencia text,capacidades text,adicional text,fecha text, hora TEXT)")
        db.execSQL("create table rescate(ID_rescate integer primary key, tipo text,comportamiento text, estado text, observacion text,genero text,fecha text, hora TEXT)")
        db.execSQL("create table usuarios(ID_usuarios integer primary key, nombre text, apellido text, rfc text, domicilio text, telefono TEXT,correo text,contraseña text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            // Realizar las actualizaciones necesarias para pasar de la versión 1 a la versión 2
            db.execSQL("create table usuarios(ID_usuarios integer primary key, nombre text, apellido text, rfc text, domicilio text, telefono TEXT,correo text,contraseña text)")
        }
    }

    companion object {
        // Incrementa este número si realizas cambios en la estructura de la base de datos
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "FeedReader.db"
    }
}