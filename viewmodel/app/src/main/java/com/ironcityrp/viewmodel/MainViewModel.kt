package com.ironcityrp.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var name: String = ""

    fun greeting() = if (name.isBlank()) "Por favor ingrese un nombre"
    else "Hola $name"
}