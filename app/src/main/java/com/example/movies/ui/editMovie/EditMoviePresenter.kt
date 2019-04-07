package com.example.movies.ui.editMovie

import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.interactor.movies.events.AddMovieEvent
import com.example.movies.interactor.movies.events.UpdateMovieEvent
import com.example.movies.model.Movie
import com.example.movies.ui.Presenter
import com.example.movies.ui.main.EditMovieScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*
import javax.inject.Inject

class EditMoviePresenter @Inject constructor(private val moviesInteractor: MoviesInteractor) :
    Presenter<EditMovieScreen>() {

    private var movie = Movie()

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()

    }

    override fun attachScreen(screen: EditMovieScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)
    }

    fun setMovie(movie: Movie) {
        this.movie.id = movie.id
        updateTitle(movie.title ?: "")
        updateReleaseDate(movie.releaseDate ?: Date())
        updateDescription(movie.description ?: "")
    }

    fun updateTitle(title: String) {
        screen?.updateTitleTextView(title)
    }

    fun updateReleaseDate(date: Date) {
        screen?.updateReleaseDatePicker(date)
    }

    fun updateDescription(description: String) {
        screen?.updateDescriptionTextView(description)
    }

    fun saveMovie() {
        if (movie.id != null) {
            moviesInteractor.addMovie(movie)
        } else {
            moviesInteractor.updateMovie(movie)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAddMovieEventMainThread(event: AddMovieEvent) {
        screen?.showMovieSaved(movie)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEditMovieEvent(event: UpdateMovieEvent) {
        screen?.showMovieSaved(movie)
    }




}