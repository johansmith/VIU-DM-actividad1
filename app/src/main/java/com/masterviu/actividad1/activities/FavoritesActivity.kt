package com.masterviu.actividad1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        initComponent()
        initUI()
    }

    private fun initComponent() {
        rvTypeMedia = findViewById(R.id.rvTypeMedia)
        rvFavorites = findViewById(R.id.rvFavorites)
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