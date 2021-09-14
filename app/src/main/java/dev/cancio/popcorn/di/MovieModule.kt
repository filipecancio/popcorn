package dev.cancio.popcorn.di

import dagger.Module
import dagger.Provides
import dev.cancio.popcorn.data.repository.MovieRepository

@Module
class MovieModule {

    @Provides
    fun provideMovie(): MovieRepository {
        return MovieRepository()
    }
}