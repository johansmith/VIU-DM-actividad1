package com.masterviu.actividad1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.masterviu.actividad1.activities.IMCCalculatorActivity
import com.masterviu.actividad1.R
import com.masterviu.actividad1.activities.FavoritesActivity

class MenuAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_app)

        val btnFavoritos = findViewById<Button>(R.id.btnFavoritos)

        /*
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val btnIMC = findViewById<Button>(R.id.btnIMC)


        btnSaludar.setOnClickListener {
            navigateToSaludar()
        }

        btnIMC.setOnClickListener {
            navigateToIMC()
        }
        */

        btnFavoritos.setOnClickListener {
            navigateToFavorites()
        }
    }

    /*
    private fun navigateToIMC() {
        val intentIMC = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intentIMC)
    }

    private fun navigateToSaludar() {
        val intentSaludar = Intent(this, FirstAppActivity::class.java)
        startActivity(intentSaludar)
    }
    */

    private fun navigateToFavorites() {
        val intentFavoritos = Intent(this, FavoritesActivity::class.java)
        startActivity(intentFavoritos)
    }


}