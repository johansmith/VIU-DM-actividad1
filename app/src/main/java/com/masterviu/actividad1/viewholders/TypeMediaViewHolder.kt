package com.masterviu.actividad1.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.contents.ContentTypeMedia

class TypeMediaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTypeMediaName: TextView = view.findViewById(R.id.tvTypeMediaName)
    private val ivIconTypeMedia: ImageView = view.findViewById(R.id.ivIconTypeMedia)
    private val cvTypeCategory: CardView = view.findViewById(R.id.cvTypeCategory)


    // En este render recibimos la función LAMBDA onTypeMediaSelected del adapter
    fun render(contentTypeMedia: ContentTypeMedia, onTypeMediaSelected:(Int) -> Unit) {

        // Pintamos el tipo de contenido seleccionado
        val color = if(contentTypeMedia.isSelected) {
            R.color.background_primary
        } else {
            R.color.purple_500
        }
        cvTypeCategory.setCardBackgroundColor(ContextCompat.getColor(cvTypeCategory.context, color))
        itemView.setOnClickListener { onTypeMediaSelected(layoutPosition) }

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