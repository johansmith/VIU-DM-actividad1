package com.masterviu.actividad1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.masterviu.actividad1.R
import com.masterviu.actividad1.adapters.TypeMediaAdapter
import com.masterviu.actividad1.tasks.TaskTypeMedia

class FavoritesActivity : AppCompatActivity() {

    private val typeMedias = listOf(
        TaskTypeMedia.Series,
        TaskTypeMedia.Peliculas,
        TaskTypeMedia.Canciones,
        TaskTypeMedia.Libros,
    )

    private lateinit var rvTypeMedia: RecyclerView
    private lateinit var typeMediaAdapter: TypeMediaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        initComponent()
        initUI()
    }

    private fun initComponent() {
        rvTypeMedia = findViewById(R.id.rvTypeMedia)
    }

    private fun initUI() {
        typeMediaAdapter = TypeMediaAdapter(typeMedias)
        rvTypeMedia.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTypeMedia.adapter = typeMediaAdapter
    }

}