package com.masterviu.actividad1.contents

sealed class ContentTypeMedia {

    object Peliculas: ContentTypeMedia()
    object Series: ContentTypeMedia()
    object Canciones: ContentTypeMedia()
    object Libros: ContentTypeMedia()
    object Deportes: ContentTypeMedia()
    object Varios: ContentTypeMedia()

}