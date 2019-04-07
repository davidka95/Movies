package com.example.movies

import android.app.Application
import com.example.movies.ui.UIModule

class MoviesApplication: Application() {
    lateinit var injector: MoviesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMoviesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}