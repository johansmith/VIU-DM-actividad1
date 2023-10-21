package com.masterviu.actividad1.viewholders

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.contents.ContentFavorites

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvFavorites:TextView = view.findViewById(R.id.tvFavorites)
    private val cbFavorites:CheckBox = view.findViewById(R.id.cbFavorites)


    fun render(favorites:ContentFavorites) {
        tvFavorites.text = favorites.name
    }

}