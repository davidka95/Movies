package com.example.movies

import android.app.Application
import com.example.movies.database.DatabaseModule
import com.example.movies.ui.UIModule
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics
import io.fabric.sdk.android.Fabric;



class MoviesApplication: Application() {
    lateinit var injector: MoviesApplicationComponent
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        injector = DaggerMoviesApplicationComponent.builder().uIModule(UIModule(this)).databaseModule(DatabaseModule(this)).build()
    }
}