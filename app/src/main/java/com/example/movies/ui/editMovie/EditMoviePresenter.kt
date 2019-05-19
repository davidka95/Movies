package com.example.movies.ui.editMovie

import android.util.Log
import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.interactor.movies.events.AddMovieEvent
import com.example.movies.interactor.movies.events.UpdateMovieEvent
import com.example.movies.model.Movie
import com.example.movies.ui.Presenter
import com.example.movies.ui.main.EditMovieScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.sql.Date
import java.text.DateFormat
import java.util.*
import javax.inject.Inject
import java.text.SimpleDateFormat
import java.util.concurrent.Executor


class EditMoviePresenter @Inject constructor(private val executor: Executor,private val moviesInteractor: MoviesInteractor) :
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
        updateTitle(movie.title)
        screen?.updateTitleTextView(this.movie.title)
        movie.releaseDate = movie.releaseDate
        screen?.updateReleaseDateTextView(movie.releaseDate.toString())
        updateDescription(movie.description)
        screen?.updateDescriptionTextView(this.movie.description)

    }

    fun updateTitle(title: String) {
        movie.title = title
    }

    fun updateReleaseDate(date: String?) {
        movie.releaseDate = date?.toInt()
    }

    fun updateDescription(description: String) {
        movie.description = description
    }

    fun saveMovie() {
        if (movie.id == null || movie.id == 0) {
            executor.execute {
                moviesInteractor.addMovie(movie)
            }
        } else {
            executor.execute {
                moviesInteractor.updateMovie(movie)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAddMovieEventMainThread(event: AddMovieEvent) {
        Log.d("EVENT", "addMovieEvent")
        if (event.code != 200) {
            event.throwable?.printStackTrace()
        } else {
            screen?.showMovieSaved(movie)
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEditMovieEvent(event: UpdateMovieEvent) {
        Log.d("EVENT", "editMovieEvent")
        if (event.code != 200) {
            event.throwable?.printStackTrace()
            Log.d("Code", event.code.toString())
        }
        else {
            screen?.showMovieSaved(movie)
        }

    }




}