package com.example.movies

import android.content.Context
import com.example.movies.database.MovieDAO
import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.network.MoviesApi
import com.example.movies.utils.UiExecutor
import com.example.movies.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MainPresenter(executor, moviesInteractor)


    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()


    @Provides
    @Singleton
    fun provideMoviesInteractor(moviesApi: MoviesApi, movieDAO: MovieDAO) = MoviesInteractor(moviesApi, movieDAO)
}