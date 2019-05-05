package com.example.movies.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(@PrimaryKey var movieId: Int?,
                 @ColumnInfo(name = "title") var title: String,
                 @ColumnInfo(name = "description") var description: String,
                 @ColumnInfo(name = "imageBase64") var imageBase64: String,
                 @ColumnInfo(name = "releaseDate") var releaseDate: Int?

)