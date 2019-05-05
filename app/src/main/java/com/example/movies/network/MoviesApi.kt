package com.example.movies.network

import com.example.movies.model.CreateMovieDto
import com.example.movies.model.Movie
import retrofit2.Call
import retrofit2.http.*

interface MoviesApi {
    /**
     *
     *
     * @return Call<List<Movie>>
     */
    @GET("Movies")
    fun getMovies(): Call<List<Movie>>

    /**
     *
     *
     * @param movieDto
     * @return Call<Movie>
     */
    @POST("Movies")
    fun postMovie(
        @Body movieDto: CreateMovieDto
    ): Call<Movie>

    /**
     *
     *
     * @param movieId
     * @param movieDto
     * @return Call<Movie>
     */
    @PUT("Movies/{movieId}")
    fun putMovie(
        @Path("movieId") movieId: Int, @Body movieDto: CreateMovieDto
    ): Call<Movie>

    /**
     *
     *
     * @param movieId
     * @return Call<Void>
     */
    @DELETE("Movies/{movieId}")
    fun deleteMovie(
        @Path("movieId") movieId: Int
    ): Call<Void>
}