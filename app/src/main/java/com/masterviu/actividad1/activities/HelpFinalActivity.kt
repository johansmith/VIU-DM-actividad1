package com.masterviu.actividad1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.masterviu.actividad1.R

class HelpFinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_final)

        val btnEndTuto = findViewById<Button>(R.id.btnEndTuto)

        btnEndTuto.setOnClickListener {
            navigateToFavorites()
        }
    }

    private fun navigateToFavorites() {
        val intentFavoritos = Intent(this, FavoritesActivity::class.java)
        startActivity(intentFavoritos)
    }
}