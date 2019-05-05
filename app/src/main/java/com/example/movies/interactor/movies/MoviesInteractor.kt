package com.example.movies.interactor.movies

import android.util.Log
import com.example.movies.interactor.movies.events.AddMovieEvent
import com.example.movies.interactor.movies.events.DeleteMovieEvent
import com.example.movies.interactor.movies.events.GetMoviesEvent
import com.example.movies.interactor.movies.events.UpdateMovieEvent
import com.example.movies.model.CreateMovieDto
import com.example.movies.model.Movie
import com.example.movies.network.MoviesApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private var moviesApi: MoviesApi) {
    fun getMovies() {
        val event = GetMoviesEvent()
        try {

            val moviesQueryCall = moviesApi.getMovies()

            val response = moviesQueryCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            Log.d("body", response.body()?.size?.toString())
            event.movies = response.body() as List<Movie>
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun addMovie(movie: Movie) {
        val event = AddMovieEvent()
        try {

            val createMovieDto = CreateMovieDto(movie.title, movie.releaseDate, movie.description, movie.imageBase64)
            val moviesQueryCall = moviesApi.postMovie(createMovieDto);

            val response = moviesQueryCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.movieId = response.body()?.id
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun updateMovie(movie: Movie) {
        val event = UpdateMovieEvent()
        try {

            val createMovieDto = CreateMovieDto(movie.title, movie.releaseDate, movie.description, movie.imageBase64)
            val moviesQueryCall = moviesApi.putMovie(movie.id ?: 0, createMovieDto);

            val response = moviesQueryCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteMovie(movieId: Int) {
        val event = DeleteMovieEvent()
        try {

            val moviesQueryCall = moviesApi.deleteMovie(movieId);

            val response = moviesQueryCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}