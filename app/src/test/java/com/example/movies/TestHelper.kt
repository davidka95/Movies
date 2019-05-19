package com.example.movies

import androidx.test.platform.app.InstrumentationRegistry
import com.example.movies.mock.MockDatabaseModule
import com.example.movies.mock.MockMovieDAO
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = InstrumentationRegistry.getInstrumentation().context as MoviesApplication
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).mockDatabaseModule(MockDatabaseModule(application.applicationContext)).build()
        application.injector = component
        return component
    }