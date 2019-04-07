package com.example.movies.interactor.movies

import com.example.movies.interactor.movies.events.AddMovieEvent
import com.example.movies.interactor.movies.events.GetMoviesEvent
import com.example.movies.interactor.movies.events.UpdateMovieEvent
import com.example.movies.model.Movie
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MoviesInteractor @Inject constructor() {
    fun getMovies() {
        val event = GetMoviesEvent()
        EventBus.getDefault().post(event)
    }

    fun addMovie(movie: Movie) {
        val event = AddMovieEvent()
        EventBus.getDefault().post(event)
    }

    fun updateMovie(movie: Movie) {
        val event = UpdateMovieEvent()
        EventBus.getDefault().post(event)
    }
}