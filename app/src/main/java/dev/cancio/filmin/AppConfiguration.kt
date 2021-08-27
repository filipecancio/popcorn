package dev.cancio.filmin

import android.app.Application
import dev.cancio.filmin.di.MovieComponent

class AppConfiguration: Application() {

    companion object{
        private lateinit var component: MovieComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = MovieComponent.builder().build()
    }

    fun getComponent() = component
}