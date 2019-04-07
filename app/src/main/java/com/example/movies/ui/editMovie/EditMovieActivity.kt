package com.example.movies.ui.editMovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.ui.injector
import com.example.movies.ui.main.EditMovieScreen
import kotlinx.android.synthetic.main.activity_edit_movie.*
import java.util.*
import javax.inject.Inject
import android.text.Editable
import android.text.TextWatcher
import com.example.movies.extensions.toEditable
import com.example.movies.interactor.movies.events.AddMovieEvent
import com.example.movies.interactor.movies.events.GetMoviesEvent
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class EditMovieActivity : AppCompatActivity(), EditMovieScreen {

    @Inject
    lateinit var editMoviePresenter: EditMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)
        injector.inject(this)

        etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                editMoviePresenter.updateTitle(s.toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })

        etDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                editMoviePresenter.updateDescription(s.toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })

        fabSaveMovie.setOnClickListener { editMoviePresenter.saveMovie() }
    }

    override fun onStart() {
        super.onStart()
        editMoviePresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        editMoviePresenter.detachScreen()
    }

    override fun showMovieSaved(movie: Movie) {
        Toast.makeText(this, "Movie is saved", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this,  error, Toast.LENGTH_SHORT).show()
    }

    override fun updateTitleTextView(title: String) {
        etTitle.text = title.toEditable()
    }

    override fun updateReleaseDatePicker(releaseDate: Date) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateDescriptionTextView(description: String) {
        etDescription.text = description.toEditable()
    }
}
