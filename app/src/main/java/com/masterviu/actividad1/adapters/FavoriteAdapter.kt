package com.masterviu.actividad1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.contents.ContentFavorites
import com.masterviu.actividad1.viewholders.FavoriteViewHolder

class FavoriteAdapter(
    var favorites:List<ContentFavorites>,
    private val onFavoriteSelected:(Int) -> Unit ) : RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val viewTypeMedia = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(viewTypeMedia)
    }
    override fun getItemCount(): Int {
        return favorites.size
    }
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.render(favorites[position])
        // Ejecutando función LAMBDA recibida por parametros
        holder.itemView.setOnClickListener{
            onFavoriteSelected(position)
        }

    }

}