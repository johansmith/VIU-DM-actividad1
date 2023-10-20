package com.masterviu.actividad1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.masterviu.actividad1.R


class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnStart = findViewById<Button>(R.id.Button1)
        val nombre = findViewById<EditText>(R.id.EditText1)

        btnStart.setOnClickListener {
            if (nombre.text.toString().isNotEmpty()) {
                val intentSecondActivity = Intent(this, SecondAppActivity::class.java)
                intentSecondActivity.putExtra("nombreValor", nombre.text.toString())

                startActivity(intentSecondActivity)
                //Log.i("Clicado","Mi mensaje ${nombre.text.toString()}")
            }
        }
    }
}