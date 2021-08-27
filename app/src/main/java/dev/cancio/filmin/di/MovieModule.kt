package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dev.cancio.filmin.data.repository.MovieRepository

@Module
class MovieModule {

    @Provides
    fun provideMovie(): MovieRepository {
        return MovieRepository()
    }
}