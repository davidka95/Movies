package com.example.movies.interactor.movies.events

import com.example.movies.model.Movie

data class GetMoviesEvent(
    var code: Int = 0,
    var movies: List<Movie>? = null,
    var throwable: Throwable? = null
)