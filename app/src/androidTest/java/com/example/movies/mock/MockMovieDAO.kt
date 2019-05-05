package com.example.movies.mock

import com.example.movies.database.Movie
import com.example.movies.database.MovieDAO

class MockMovieDAO : MovieDAO {
    override fun getAllMovie(): List<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertMovie(vararg movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMovie(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}