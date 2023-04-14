package com.avsc.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var nameTI: EditText
    private lateinit var emailTI: EditText
    private lateinit var phoneTI: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind() {
        nameTI = findViewById(R.id.name)
        emailTI = findViewById(R.id.email)
        phoneTI = findViewById(R.id.phone)
        saveButton = findViewById(R.id.button)

    }

    private fun addListener() {
        saveButton.setOnClickListener {
            val intent = Intent(this, ActivityShare::class.java)

            val nameFill = nameTI.text.toString()
            val emailFill = emailTI.text.toString()
            val phoneFill = phoneTI.text.toString()

            intent.putExtra("name", nameFill)
            intent.putExtra("email", emailFill)
            intent.putExtra("phone", phoneFill)

            startActivity(intent)
        }
    }
}