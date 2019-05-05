package com.example.movies.ui.main

import com.example.movies.model.Movie
import java.util.*

interface EditMovieScreen {
    fun showMovieSaved(movie: Movie)
    fun showError(error: String)
    fun updateTitleTextView(title: String)
    fun updateReleaseDatePicker(releaseDate: Int)
    fun updateDescriptionTextView(description: String)
}