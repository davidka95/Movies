package com.example.movies.interactor.movies.events

import com.example.movies.model.Movie

data class AddMovieEvent(
    var code: Int = 0,
    var movieId: Int? = null,
    var throwable: Throwable? = null
)