package com.masterviu.actividad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.masterviu.actividad1.R

class SecondAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_app)
        val etiNombre = findViewById<TextView>(R.id.EtiquetaNombre)
        val nombre: String = intent.extras?.getString("nombreValor").orEmpty()
        etiNombre.text = "Bienvenido, ${nombre}"
    }
}