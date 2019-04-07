package com.example.movies.ui.movieDetails

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.ui.editMovie.EditMovieActivity
import com.example.movies.ui.injector
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsScreen {
    override fun updateTitleTextView(title: String) {
        tvTitle.text = title
    }

    override fun updateDescriptionTextView(description: String) {
        tvDescription.text = description
    }

    override fun updateImage(imageUrl: String) {

    }

    override fun updateReleaseDate(releaseDateString: String) {
        tvReleaseDate.text = releaseDateString
    }

    override fun editMovie(movie: Movie) {
        val intent = Intent(this, EditMovieActivity::class.java)
        startActivity(intent)
    }


    @Inject
    lateinit var movieDetailsPresenter: MovieDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        injector.inject(this)
        // TODO: Get Movies from intent
        movieDetailsPresenter.movie = Movie()
    }

}
