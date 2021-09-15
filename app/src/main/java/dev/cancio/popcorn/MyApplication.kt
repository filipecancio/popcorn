package dev.cancio.popcorn

import android.app.Application
import dev.cancio.popcorn.di.DaggerMainComponent

class MyApplication: Application() {

    val appComponent = DaggerMainComponent.builder().build()
}