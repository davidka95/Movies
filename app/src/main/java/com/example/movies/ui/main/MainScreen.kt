package com.example.movies.ui.main

import com.example.movies.model.Movie

interface MainScreen {
    fun showMovieDetails(movieId: Int)
    fun showCreateMovie()
    fun showMovieList(movies: List<Movie>)
}