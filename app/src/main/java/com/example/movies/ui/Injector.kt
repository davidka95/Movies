package com.example.movies.ui

import android.app.Activity
import android.support.v4.app.Fragment
import com.example.movies.MoviesApplication
import com.example.movies.MoviesApplicationComponent


val Activity.injector: MoviesApplicationComponent
    get() {
        return (this.applicationContext as MoviesApplication).injector
    }

val Fragment.injector: MoviesApplicationComponent
    get() {
        return (this.context!!.applicationContext as MoviesApplication).injector
    }