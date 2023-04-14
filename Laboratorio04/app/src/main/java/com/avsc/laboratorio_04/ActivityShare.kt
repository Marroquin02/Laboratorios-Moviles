package com.avsc.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityShare : AppCompatActivity() {
    // UI elements
    private lateinit var shareBtn: Button

    //values
    var nameFill: String = ""
    var emailFill: String = ""
    var phoneFill: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameFill = intent.getStringExtra("name").toString()
        emailFill = intent.getStringExtra("email").toString()
        phoneFill = intent.getStringExtra("phone").toString()
        phoneFill = intent.getStringExtra("phone").toString()

        findViewById<TextView>(R.id.fill_name_TV)?.let { it.text = nameFill }
        findViewById<TextView>(R.id.fill_email_TV)?.let { it.text = emailFill }
        findViewById<TextView>(R.id.fill_phone_TV)?.let { it.text = phoneFill }

        bind()
        addListener()
    }

    private fun bind() {
        shareBtn = findViewById(R.id.share_button)

    }

    private fun addListener() {

        shareBtn.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, getString(
                        R.string.share_text, nameFill,
                        emailFill, phoneFill
                    )
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}