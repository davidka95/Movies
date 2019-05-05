package com.example.movies.mock

import com.example.movies.model.CreateMovieDto
import com.example.movies.model.Movie
import com.example.movies.network.MoviesApi
import retrofit2.Call

class MockMovieApi : MoviesApi {
    override fun getMovies(): Call<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postMovie(movieDto: CreateMovieDto): Call<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun putMovie(movieId: Int, movieDto: CreateMovieDto): Call<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMovie(movieId: Int): Call<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}