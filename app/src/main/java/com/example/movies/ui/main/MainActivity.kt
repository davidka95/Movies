package com.example.movies.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.ui.editMovie.EditMovieActivity
import com.example.movies.ui.injector
import com.example.movies.ui.movieDetails.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        btnCreateMovie.setOnClickListener{ mainPresenter.showCreateMovie() }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.refreshMoviesList()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showMovieDetails(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        //TODO: Put movie extra as parcelable
        startActivity(intent)
    }

    override fun showCreateMovie() {
        val intent = Intent(this, EditMovieActivity::class.java)
        startActivity(intent)
    }

    override fun showMovieList(movies: List<Movie>) {
        Toast.makeText(this, "List refreshed", Toast.LENGTH_SHORT).show()
    }


}
