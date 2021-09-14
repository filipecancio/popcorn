package dev.cancio.popcorn

import android.app.Application
import dev.cancio.popcorn.di.DaggerMovieComponent

class MyApplication: Application() {

    val appComponent = DaggerMovieComponent.builder().build()
}