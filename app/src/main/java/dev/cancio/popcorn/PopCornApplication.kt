package dev.cancio.popcorn

import android.app.Application
import dev.cancio.popcorn.di.ApplicationComponent
import dev.cancio.popcorn.di.DaggerApplicationComponent


class PopCornApplication: Application() {

    val appComponent: ApplicationComponent by lazy {
        buildComponent()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.injectMembers(this)
    }

    fun buildComponent(): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .popCornApplication(this)
            .build()
}