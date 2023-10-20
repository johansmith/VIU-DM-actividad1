package com.masterviu.actividad1.tasks

sealed class TaskTypeMedia {

    object Peliculas: TaskTypeMedia()
    object Series: TaskTypeMedia()
    object Canciones: TaskTypeMedia()
    object Libros: TaskTypeMedia()

}