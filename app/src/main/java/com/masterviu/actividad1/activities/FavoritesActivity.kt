package com.masterviu.actividad1.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.masterviu.actividad1.R
import com.masterviu.actividad1.adapters.FavoriteAdapter
import com.masterviu.actividad1.adapters.TypeMediaAdapter
import com.masterviu.actividad1.contents.ContentFavorites
import com.masterviu.actividad1.contents.ContentTypeMedia
import com.masterviu.actividad1.contents.ContentTypeMedia.*

class FavoritesActivity : AppCompatActivity() {

    private val typeMedias = listOf(
        Series,
        Peliculas,
        Canciones,
        Libros,
        Varios,
    )

    private val favorites = mutableListOf(
        ContentFavorites("The Boys", Series),
        ContentFavorites("The Walking Dead", Series),
        ContentFavorites("House of the dragon", Series)
    )

    private lateinit var rvTypeMedia: RecyclerView
    private lateinit var rvFavorites: RecyclerView
    private lateinit var typeMediaAdapter: TypeMediaAdapter
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var fabNewFavorite: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabNewFavorite.setOnClickListener { showDialogNewFavorite() }
    }

    private fun showDialogNewFavorite() {
        val dialogNewFavorite = Dialog(this)
        dialogNewFavorite.setContentView(R.layout.dialog_new_favorite)

        // Eventos dentro del Dialog
        val btnNewFavorite: Button = dialogNewFavorite.findViewById(R.id.btnNewFavorite)
        val etNewFavorite: EditText = dialogNewFavorite.findViewById(R.id.etNewFavorite)
        val grbListTypeMedia: RadioGroup = dialogNewFavorite.findViewById(R.id.grbListTypeMedia)

        btnNewFavorite.setOnClickListener {
            // Aquí capturo el RadioButton seleccionado por el usuario
            val selectedTypeMedia = grbListTypeMedia.checkedRadioButtonId
            val selectedRadioButton: RadioButton = grbListTypeMedia.findViewById(selectedTypeMedia)
            val currentCategory: ContentTypeMedia = when (selectedRadioButton.text) {
                "Series" -> Series
                "Peliculas" -> Peliculas
                "Canciones" -> Canciones
                "Libros" -> Libros
                else -> Varios
            }
            favorites.add(ContentFavorites(etNewFavorite.text.toString(), currentCategory))
            updateFavorites()
            dialogNewFavorite.hide()

        }
        dialogNewFavorite.show()
    }

    // Esta función notifica al adaptor para que se entere que se han agregado nuevos items
    private fun updateFavorites() {
        favoriteAdapter.notifyDataSetChanged()
    }

    private fun initComponent() {
        rvTypeMedia = findViewById(R.id.rvTypeMedia)
        rvFavorites = findViewById(R.id.rvFavorites)
        fabNewFavorite = findViewById(R.id.fabNewFavorite)
    }

    private fun initUI() {
        typeMediaAdapter = TypeMediaAdapter(typeMedias)
        rvTypeMedia.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTypeMedia.adapter = typeMediaAdapter

        favoriteAdapter = FavoriteAdapter(favorites)
        rvFavorites.layoutManager = LinearLayoutManager(this)
        rvFavorites.adapter = favoriteAdapter

    }

}