package com.example.movies.ui.main

import com.example.movies.ui.Presenter

class MainPresenter: Presenter<MainScreen>() {

    fun showMovieDetails(movieId: Int) {
        screen?.showMovieDetails(movieId)
    }

    fun showCreateMovie() {
        screen?.showCreateMovie()
    }
}