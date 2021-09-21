package dev.cancio.popcorn.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.cancio.popcorn.PopcornApplication
import dev.cancio.popcorn.data.db.PopcornDatabase
import dev.cancio.popcorn.data.service.MovieService
import retrofit2.Retrofit

@Module
class PopCornModule {

    @Provides
    fun provideMovie(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideDatabase(popcornApplication: PopcornApplication) = Room
        .databaseBuilder(popcornApplication, PopcornDatabase::class.java, "popcorn-db")
        .allowMainThreadQueries()
        .build()

    @Provides
    fun provideDao(database: PopcornDatabase) = database.popCornDao()


}