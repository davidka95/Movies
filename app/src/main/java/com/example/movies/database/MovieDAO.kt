package com.example.movies.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): List<Movie>

    @Insert
    fun insertMovie(vararg movie: Movie)

    @Query("DELETE FROM movie where movieId == :id")
    fun deleteMovie(id: Int)

    @Query("Select * FROM movie where movieId == :id")
    fun getMovie(id: Int): List<Movie>

}