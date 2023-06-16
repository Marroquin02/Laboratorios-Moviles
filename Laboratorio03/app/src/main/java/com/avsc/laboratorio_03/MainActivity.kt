package com.ironcityrp.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnFiveCents: ImageView
    private lateinit var btnTenCents: ImageView
    private lateinit var btnDollarCents: ImageView
    private lateinit var btnQuarterCents: ImageView
    private lateinit var DisplayMoney: TextView

    private var contador = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        clickListenersFunction()
    }

    private fun bind(){
        btnFiveCents = findViewById(R.id.image_five_cents)
        btnTenCents = findViewById(R.id.ten_cents)
        btnQuarterCents = findViewById(R.id.quarter_cents)
        btnDollarCents = findViewById(R.id.one_dollar)

        DisplayMoney =findViewById(R.id.cont)
    }

    private fun clickListenersFunction(){
        btnFiveCents.setOnClickListener{
            contador += 0.05
            DisplayMoney.text ="$${String.format("%.2f",contador)}"
        }

        btnTenCents.setOnClickListener{
            contador += 0.10
            DisplayMoney.text ="$${String.format("%.2f",contador)}"
        }

        btnQuarterCents.setOnClickListener{
            contador += 0.25
            DisplayMoney.text ="$${String.format("%.2f",contador)}"
        }

        btnDollarCents.setOnClickListener{
            contador += 1.00
            DisplayMoney.text ="$${String.format("%.2f",contador)}"
        }
    }
}