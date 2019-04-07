package com.example.movies.interactor.movies.events

import com.example.movies.model.Movie

data class UpdateMovieEvent(
    var code: Int = 0,
    var throwable: Throwable? = null
)