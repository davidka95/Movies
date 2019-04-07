package com.example.movies.ui

import android.content.Context
import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(moviesInteractor: MoviesInteractor) = MainPresenter(moviesInteractor)
}