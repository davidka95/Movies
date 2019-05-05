package com.example.movies.database

import dagger.Provides
import javax.inject.Singleton
import android.content.Context
import dagger.Module


@Module
class DatabaseModule(context: Context) {

    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    internal fun providesMovieDAO(): MovieDAO {
        return appDatabase.movieDao()
    }

}