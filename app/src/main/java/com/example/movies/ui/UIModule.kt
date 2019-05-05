package com.example.movies.ui

import android.content.Context
import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MainPresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}