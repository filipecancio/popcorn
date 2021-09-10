package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun provideMovie(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}