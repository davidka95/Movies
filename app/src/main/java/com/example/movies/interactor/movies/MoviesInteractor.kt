package com.example.movies.interactor.movies

import com.example.movies.interactor.movies.events.GetMoviesEvent
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MoviesInteractor @Inject constructor() {
    fun getMovies() {
        val event = GetMoviesEvent()
        EventBus.getDefault().post(event)
    }
}