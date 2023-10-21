package com.masterviu.actividad1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masterviu.actividad1.R
import com.masterviu.actividad1.contents.ContentTypeMedia
import com.masterviu.actividad1.viewholders.TypeMediaViewHolder

class TypeMediaAdapter(private val type_medias:List<ContentTypeMedia>) :
    RecyclerView.Adapter<TypeMediaViewHolder>() {

    // CREA LA LISTA DE OBJETOS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeMediaViewHolder {
        val viewTypeMedia = LayoutInflater.from(parent.context).inflate(R.layout.item_type_media, parent, false)
        return TypeMediaViewHolder(viewTypeMedia)
    }

    // CUENTA LA LONGITUD DE LA LISTA DE OBJETOS

    override fun getItemCount(): Int {
        return type_medias.size
    }

    // ALIMENTA LA LISTA DE OBJETOS
    override fun onBindViewHolder(holder: TypeMediaViewHolder, position: Int) {
        holder.render(type_medias[position])
    }

}