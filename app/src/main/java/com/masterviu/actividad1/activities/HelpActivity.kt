package com.masterviu.actividad1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.masterviu.actividad1.R

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val btnNextTuto = findViewById<Button>(R.id.btnNextTuto)

        btnNextTuto.setOnClickListener {
            navigateToNextTuto()
        }
    }

    private fun navigateToNextTuto() {
        val intentNextTuto = Intent(this, HelpFinalActivity::class.java)
        startActivity(intentNextTuto)
    }
}