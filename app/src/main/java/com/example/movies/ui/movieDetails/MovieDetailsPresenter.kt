package com.example.movies.ui.movieDetails

import android.util.Log
import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.interactor.movies.events.FavoriteEvent
import com.example.movies.interactor.movies.events.UpdateMovieEvent
import com.example.movies.model.Movie
import com.example.movies.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor): Presenter<MovieDetailsScreen>() {


    var movie: Movie = Movie()
        set(value) {
            field = value
            updateScreen(value)
        }

    var isFavorite: Boolean = false

    override fun attachScreen(screen: MovieDetailsScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)

    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    private fun updateScreen(movie: Movie) {
        executor.execute{
            moviesInteractor.isMovieFavourite(movie)
        }
        screen?.updateDescriptionTextView(movie.description ?: "")
        screen?.updateTitleTextView(movie.title?: "")
        screen?.updateImage(movie.imageBase64?: "")
        screen?.updateReleaseDate(movie.releaseDate?.toString()?: "")
    }

    fun editMovie() {
        screen?.editMovie(movie)
    }

    fun saveMovieOffline() {
        if (isFavorite) {
            executor.execute {
                moviesInteractor.removeSavedMovie(movie.id!!)
                isFavorite = false
                screen?.updateFavorite(isFavorite)
            }
        } else {
            executor.execute {
                moviesInteractor.saveMovie(movie)
                isFavorite = true
                screen?.updateFavorite(isFavorite)
            }
        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFavoriteEvent(event: FavoriteEvent) {
        isFavorite = event.isFavorite
        screen?.updateFavorite(isFavorite)
    }


}