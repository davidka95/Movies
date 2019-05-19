package com.example.movies.test

import android.util.Log
import com.example.movies.model.Movie
import com.example.movies.testInjector
import com.example.movies.ui.main.MainPresenter
import com.example.movies.ui.main.MainScreen
import com.example.movies.utils.argumentCaptor
import com.example.movies.utils.mock
import com.example.movies.utils.nullableArgumentCaptor
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var moviesScreen: MainScreen


    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        moviesScreen = mock()
        mainPresenter.attachScreen(moviesScreen)
    }

    @Test
    fun testMovies() {
        mainPresenter.refreshMoviesList()

        nullableArgumentCaptor<List<Movie>>().apply {
            if (this.capture() != null) {
                verify(moviesScreen).showMovieList(this.capture()!!)
                assert(this.value?.size!! > 0)
            }
        }
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}