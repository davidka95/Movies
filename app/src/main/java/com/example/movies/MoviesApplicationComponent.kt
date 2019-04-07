package com.example.movies

import com.example.movies.ui.UIModule
import com.example.movies.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])
interface MoviesApplicationComponent {
    fun inject(mainActivity: MainActivity)
}