package com.example.movies.ui.movieDetails

import com.example.movies.model.Movie

interface MovieDetailsScreen {
    fun updateTitleTextView(title: String)
    fun updateDescriptionTextView(description: String)
    fun updateImage(imageBase64: String)
    fun updateReleaseDate(releaseDateString: String)
    fun editMovie(movie: Movie)
}