package com.masterviu.actividad1.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.tasks.TaskTypeMedia

class TypeMediaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTypeMediaName: TextView = view.findViewById(R.id.tvTypeMediaName)
    private val ivIconTypeMedia: ImageView = view.findViewById(R.id.ivIconTypeMedia)

    fun render(taskTypeMedia: TaskTypeMedia) {
        when(taskTypeMedia) {
            TaskTypeMedia.Canciones -> {
                tvTypeMediaName.text = "Canciones"
                ivIconTypeMedia.setImageResource(R.drawable.ic_songs);
            }
            TaskTypeMedia.Libros -> {
                tvTypeMediaName.text = "Libros"
                ivIconTypeMedia.setImageResource(R.drawable.ic_books);
            }
            TaskTypeMedia.Peliculas -> {
                tvTypeMediaName.text = "Peliculas"
                ivIconTypeMedia.setImageResource(R.drawable.ic_movies);
            }
            TaskTypeMedia.Series -> {
                tvTypeMediaName.text = "Series"
                ivIconTypeMedia.setImageResource(R.drawable.ic_series);
            }
        }

    }

}