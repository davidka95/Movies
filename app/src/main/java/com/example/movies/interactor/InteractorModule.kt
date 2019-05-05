package com.example.movies.interactor;

import com.example.movies.interactor.movies.MoviesInteractor
import com.example.movies.network.MoviesApi
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideMoviesInteractor(moviesApi: MoviesApi) = MoviesInteractor(moviesApi)
}
