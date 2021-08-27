package dev.cancio.filmin

import android.app.Application
import dev.cancio.filmin.di.DaggerMovieComponent
import dev.cancio.filmin.di.MovieComponent

class MyApplication: Application() {

    val appComponent = DaggerMovieComponent.builder().build()
}