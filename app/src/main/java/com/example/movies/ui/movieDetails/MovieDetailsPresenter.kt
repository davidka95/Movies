package com.example.movies.ui.movieDetails

import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.model.Movie
import com.example.movies.ui.Presenter
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(private val moviesInteractor: MoviesInteractor): Presenter<MovieDetailsScreen>() {


    var movie: Movie = Movie()
        set(value) {
            field = value
            updateScreen(value)
        }

    override fun attachScreen(screen: MovieDetailsScreen) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    private fun updateScreen(movie: Movie) {
        screen?.updateDescriptionTextView(movie.description ?: "")
        screen?.updateTitleTextView(movie.title?: "")
        screen?.updateImage(movie.imageBase64?: "")
        screen?.updateReleaseDate(movie.releaseDate?.toString()?: "")
    }

    fun editMovie() {
        screen?.editMovie(movie)
    }


}