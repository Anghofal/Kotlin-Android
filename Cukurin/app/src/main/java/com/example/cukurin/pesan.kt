package com.example.cukurin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class pesan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)
        init()
    }

    private fun init(){
        val namaBarber = findViewById<TextView>(R.id.judulBarber)
        val deksBarber = findViewById<TextView>(R.id.deksBarber2)

        val nama = intent.getStringExtra("nama").toString()
        val deks = intent.getStringExtra("deks").toString()

        namaBarber.text = nama
        deksBarber.text = deks
    }
}