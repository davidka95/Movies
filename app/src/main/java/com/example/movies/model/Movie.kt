package com.example.movies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Movie(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("descripition")
    var description:String = "",
    @SerializedName("imageBase64")
    var imageBase64:String = "",
    @SerializedName("releaseDate")
    var releaseDate:Int? = null
): Serializable