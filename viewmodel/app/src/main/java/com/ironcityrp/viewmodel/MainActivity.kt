package com.ironcityrp.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var displayName: TextView
    private lateinit var sendButton: Button

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
        displayName.text = viewModel.greeting()
    }

    private fun addListener() {
        sendButton.setOnClickListener {
            viewModel.name = nameEditText.text.toString()
            displayName.text = viewModel.greeting()
        }
    }

    fun bind() {
        nameEditText = findViewById(R.id.edit_text_name)
        displayName = findViewById(R.id.display_name)
        sendButton = findViewById(R.id.action_button)
    }
}