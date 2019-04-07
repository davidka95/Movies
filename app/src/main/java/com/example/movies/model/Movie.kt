package com.example.movies.model

import java.util.*

data class Movie(
    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var releaseDate: Date? = null,
    var description: String? = null
)