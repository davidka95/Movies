package com.example.movies

import com.example.movies.interactor.InteractorModule
import com.example.movies.network.NetworkModule
import com.example.movies.ui.UIModule
import com.example.movies.ui.editMovie.EditMovieActivity
import com.example.movies.ui.main.MainActivity
import com.example.movies.ui.movieDetails.MovieDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, NetworkModule::class])
interface MoviesApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(editMovieActivity: EditMovieActivity)
    fun inject(movieDetailsActivity: MovieDetailsActivity)
}