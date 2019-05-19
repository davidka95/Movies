package com.example.movies.ui.movieDetails

import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.ui.editMovie.EditMovieActivity
import com.example.movies.ui.injector
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsScreen {

    override fun updateTitleTextView(title: String) {
        tvTitle.text = title
    }

    override fun updateDescriptionTextView(description: String) {
        tvDescription.text = description
    }

    override fun updateImage(imageBase64: String) {
        if (imageBase64.isEmpty()) {
            ivPoster.setImageDrawable(resources.getDrawable(R.drawable.image_placeholder))
        } else {
            val decodedString = Base64.decode(imageBase64, Base64.DEFAULT)
            val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

            ivPoster.setImageBitmap(decodedByte)
        }
    }

    override fun updateReleaseDate(releaseDateString: String) {
        tvReleaseDate.text = releaseDateString
    }

    override fun editMovie(movie: Movie) {
        val intent = Intent(this, EditMovieActivity::class.java)
        intent.putExtra("MOVIE_KEY", movie)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.edit -> {
                movieDetailsPresenter.editMovie()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun updateFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            fabFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            fabFavorite.setImageResource(R.drawable.ic_favorite_border)
        }

    }


    @Inject
    lateinit var movieDetailsPresenter: MovieDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        fabFavorite.setOnClickListener {
            movieDetailsPresenter.saveMovieOffline()
        }
        injector.inject(this)

    }

    override fun onStart() {
        super.onStart()
        movieDetailsPresenter.attachScreen(this)
        val movie = intent.extras?.getSerializable("MOVIE_KEY") as? Movie
        if (movie != null) {
            Log.d("DEBUG_KEY", movie.title)
            movieDetailsPresenter.movie = movie
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        movieDetailsPresenter.detachScreen()
    }

}
