package com.example.movies.mock

import android.content.Context
import com.example.movies.database.AppDatabase
import com.example.movies.database.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule(context: Context) {

    @Singleton
    @Provides
    internal fun providesMovieDAO(): MovieDAO {
        return MockMovieDAO()
    }

}