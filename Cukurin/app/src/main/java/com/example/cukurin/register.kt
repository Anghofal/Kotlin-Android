package com.example.cukurin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }

    private fun homeAct(){
        val intent = Intent(this,Home::class.java)
        startActivity(intent)
    }

    private fun init(){
        val RegUs = findViewById<Button>(R.id.registerUser)
        val RegBr = findViewById<Button>(R.id.registerBarber)
        val tampilanRegUs = findViewById<LinearLayout>(R.id.tampilanRegUs)
        val tampilanRegBr = findViewById<LinearLayout>(R.id.tampilanRegBr)
        val sendRegBr = findViewById<Button>(R.id.sendRegBr)
        val sendRegUs = findViewById<Button>(R.id.pesanUs)

        RegUs.setOnClickListener {
            tampilanRegUs.visibility = View.VISIBLE
            tampilanRegBr.visibility = View.GONE
        }

        RegBr.setOnClickListener {
            tampilanRegBr.visibility = View.VISIBLE
            tampilanRegUs.visibility = View.GONE
        }

        sendRegBr.setOnClickListener {
            homeAct()
        }

        sendRegUs.setOnClickListener {
            homeAct()
        }


    }
}