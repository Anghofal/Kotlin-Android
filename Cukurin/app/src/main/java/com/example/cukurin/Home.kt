package com.example.cukurin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()

    }

    private fun init(){
        val listbarber = findViewById<RecyclerView>(R.id.listBarber)
        val arraylist = ArrayList<arrayListAdapter>()
        arraylist.add(arrayListAdapter("Contoh nama Barber Shop","Dekskirpsiiiiiiiiiiiiiiiiiiiiii Deksripsiiiiiiiiiiiiiiiiiiiiiiiiiii"))
        listbarber.adapter = adapterBarber(arraylist)
        listbarber.layoutManager = LinearLayoutManager(this)

    }

}