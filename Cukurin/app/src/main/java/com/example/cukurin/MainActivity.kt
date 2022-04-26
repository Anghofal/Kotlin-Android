package com.example.cukurin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun homeAct(){
        val intent = Intent(this,Home::class.java)
        startActivity(intent)
    }

    private fun regAct(){
        val intent = Intent(this,register::class.java)
        startActivity(intent)
    }

    private fun init(){
        val register = findViewById<TextView>(R.id.register)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val edtName = findViewById<EditText>(R.id.edtNama)
        val edtPass = findViewById<EditText>(R.id.edtPass)

        btnLogin.setOnClickListener{
            homeAct()
        }
        register.setOnClickListener {
            regAct()
        }
    }
}