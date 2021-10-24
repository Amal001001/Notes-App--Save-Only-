package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var db:DBHlper
    lateinit var rv:RecyclerView
    lateinit var et:EditText
    lateinit var button:Button
    var note = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHlper(this)

        rv = findViewById(R.id.rv)
        et = findViewById(R.id.et)
        button = findViewById(R.id.button)

        button.setOnClickListener { postNote() }

    }
    fun postNote(){
        db.saveData(Notes(0,et.text.toString()))
        et.text.clear()
        Toast.makeText(applicationContext,"note added", Toast.LENGTH_LONG).show()
    }
}