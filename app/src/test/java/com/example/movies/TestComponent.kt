package com.example.movies

import com.example.movies.interactor.InteractorModule
import com.example.movies.mock.MockDatabaseModule
import com.example.movies.mock.MockNetworkModule
import com.example.movies.test.MainTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, MockDatabaseModule::class])
interface TestComponent : MoviesApplicationComponent {
    fun inject(mainTest: MainTest)

}