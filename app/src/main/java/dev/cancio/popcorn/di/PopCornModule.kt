package dev.cancio.popcorn.di

import dagger.Module
import dagger.Provides
import dev.cancio.popcorn.data.service.MovieService
import retrofit2.Retrofit

@Module
class PopCornModule {

    @Provides
    fun provideMovie(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}