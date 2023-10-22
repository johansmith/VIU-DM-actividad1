package com.masterviu.actividad1.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.contents.ContentTypeMedia

class TypeMediaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTypeMediaName: TextView = view.findViewById(R.id.tvTypeMediaName)
    private val ivIconTypeMedia: ImageView = view.findViewById(R.id.ivIconTypeMedia)

    fun render(contentTypeMedia: ContentTypeMedia) {
        when(contentTypeMedia) {
            ContentTypeMedia.Canciones -> {
                tvTypeMediaName.text = "Canciones"
                ivIconTypeMedia.setImageResource(R.drawable.ic_songs);
            }
            ContentTypeMedia.Libros -> {
                tvTypeMediaName.text = "Libros"
                ivIconTypeMedia.setImageResource(R.drawable.ic_books);
            }
            ContentTypeMedia.Peliculas -> {
                tvTypeMediaName.text = "Peliculas"
                ivIconTypeMedia.setImageResource(R.drawable.ic_movies);
            }
            ContentTypeMedia.Series -> {
                tvTypeMediaName.text = "Series"
                ivIconTypeMedia.setImageResource(R.drawable.ic_series);
            }
            ContentTypeMedia.Deportes -> {
                tvTypeMediaName.text = "Deportes"
                ivIconTypeMedia.setImageResource(R.drawable.ic_sports);
            }
            ContentTypeMedia.Varios -> {
                tvTypeMediaName.text = "Varios"
                ivIconTypeMedia.setImageResource(R.drawable.ic_several);
            }
        }

    }

}