package dev.cancio.filmin

import android.app.Application
import dev.cancio.filmin.di.DaggerMainComponent

class MyApplication: Application() {

    val appComponent = DaggerMainComponent.builder().build()
}