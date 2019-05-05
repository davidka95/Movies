package com.example.movies.interactor.movies.events

data class DeleteMovieEvent(
    var code: Int = 0,
    var throwable: Throwable? = null
)