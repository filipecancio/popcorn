package dev.cancio.popcorn

import android.app.Application
import androidx.room.Room
import dev.cancio.popcorn.data.db.PopcornDatabase
import dev.cancio.popcorn.di.DaggerMainComponent

class MyApplication: Application() {

    val appComponent = DaggerMainComponent.builder().build()

    override fun onCreate() {
        super.onCreate()

        val database = Room
            .databaseBuilder(this, PopcornDatabase::class.java, "popcorn-db")
            .allowMainThreadQueries()
            .build()
    }
}