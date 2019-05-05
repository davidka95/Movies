package com.example.movies.ui.main

import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.interactor.movies.events.GetMoviesEvent
import com.example.movies.model.Movie
import com.example.movies.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor): Presenter<MainScreen>() {

    fun showMovieDetails(movieId: Int) {
        screen?.showMovieDetails(movieId)
    }

    fun showCreateMovie() {
        screen?.showCreateMovie()
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()

    }

    override fun attachScreen(screen: MainScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)
    }

    fun refreshMoviesList() {
        executor.execute {
            moviesInteractor.getMovies()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetMoviesEvent) {
        screen?.showMovieList(event.movies ?: ArrayList())
    }
}