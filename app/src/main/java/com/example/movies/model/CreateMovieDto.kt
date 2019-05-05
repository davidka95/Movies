package com.example.movies.model;

import com.google.gson.annotations.SerializedName;
import java.util.*


data class CreateMovieDto(
  @SerializedName("title")
  var title:String= "",
  @SerializedName("releaseDate")
  var releaseDate: Date? = null,
  @SerializedName("descripition")
  var description:String = "",
  @SerializedName("imageBase64")
 var imageBase64:String = ""
)