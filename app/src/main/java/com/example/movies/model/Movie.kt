package com.example.movies.model

data class Movie(
    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var releaseDate: String? = null,
    var description: String? = null
)