package com.masterviu.actividad1.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        Deportes,
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
            val currentFavorite = etNewFavorite.text.toString()
            if(currentFavorite.isNotEmpty()) {
                val selectedTypeMedia = grbListTypeMedia.checkedRadioButtonId
                val selectedRadioButton: RadioButton = grbListTypeMedia.findViewById(selectedTypeMedia)
                Log.i("PRUEBA", selectedRadioButton.text.toString())
                val currentCategory: ContentTypeMedia = when (selectedRadioButton.text) {
                    getString(R.string.ContentTypeMediaSeries) -> Series
                    getString(R.string.ContentTypeMediaPeliculas) -> Peliculas
                    getString(R.string.ContentTypeMediaDeportes) -> Deportes
                    getString(R.string.ContentTypeMediaCanciones) -> Canciones
                    getString(R.string.ContentTypeMediaLibros) -> Libros
                    else -> Varios
                }
                favorites.add(ContentFavorites(currentFavorite, currentCategory))
                updateFavorites()
                dialogNewFavorite.hide()
            }
        }
        dialogNewFavorite.show()
    }

    // Actualizando la lista para tachar los items, esta es una función LAMBDA que invocaremos posteriormente en el adaptador
    private fun onItemSelected(position:Int) {
        favorites[position].isSelected = !favorites[position].isSelected
        updateFavorites()
    }

    // Esta función notifica al adaptor para que se entere que se han agregado nuevos items
    private fun updateFavorites() {
        // Filtamos solo los favoritos que pertenezcan al tipo de contenido seleccionado
        val selectedTypeMedia: List<ContentTypeMedia> = typeMedias.filter { it.isSelected }
        val newFavorites = favorites.filter { selectedTypeMedia.contains(it.typeMedia) }
        // Asignamos la nueva lista de favoritos filtrada al Adapter de favoritos
        favoriteAdapter.favorites = newFavorites
        favoriteAdapter.notifyDataSetChanged()
    }

    private fun onItemSelectedCategories(position:Int){
        typeMedias[position].isSelected = !typeMedias[position].isSelected
        // Notificamos al adaptador solo el item actualizado
        typeMediaAdapter.notifyItemChanged(position)
        updateFavorites()
    }

    private fun initComponent() {
        rvTypeMedia = findViewById(R.id.rvTypeMedia)
        rvFavorites = findViewById(R.id.rvFavorites)
        fabNewFavorite = findViewById(R.id.fabNewFavorite)
    }

    private fun initUI() {
        // El primer parametro para nuestro adaptador es la lista de objetos
        // El segundo parametro es la función Lambda que nos permite actualizar el color de fondo en la posición elegida por el usuario
        typeMediaAdapter = TypeMediaAdapter(typeMedias, {position -> onItemSelectedCategories(position)})
        rvTypeMedia.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTypeMedia.adapter = typeMediaAdapter

        // El primer parametro para nuestro adaptador es la lista de objetos
        // El segundo parametro es la función Lambda que nos permite actualizar el item seleccionado para tacharlo en la posición elegida por el usuario
        favoriteAdapter = FavoriteAdapter(favorites, {position -> onItemSelected(position)})
        rvFavorites.layoutManager = LinearLayoutManager(this)
        rvFavorites.adapter = favoriteAdapter

    }

}