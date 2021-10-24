package com.example.notesappsaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlper(context: Context):SQLiteOpenHelper(context,"NotesDatabase",null,1) {
    var sqLiteDatabase :SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table NotesTable (Id INTEGER PRIMARY KEY,Note text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun saveData(note:Notes): Long {
        val cv = ContentValues()
        cv.put("Note",note.note)
        var status = sqLiteDatabase.insert("NotesTable",null,cv)
        return status
    }
}