package com.example.movies.mock

import com.example.movies.model.CreateMovieDto
import com.example.movies.model.Movie
import com.example.movies.network.MoviesApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockMovieApi : MoviesApi {
    override fun getMovies(): Call<List<Movie>> {
        val movies = ArrayList<Movie>()

        val movie = Movie()

        movie.title = "Avangers End Game"
        movie.description = "Description"
        movie.id = 1
        movie.releaseDate = 2019

        movies.add(movie)

        val call = object : Call<List<Movie>> {
            @Throws(IOException::class)
            override fun execute(): Response<List<Movie>> {
                return Response.success(movies)
            }

            override fun enqueue(callback: Callback<List<Movie>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<Movie>> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
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