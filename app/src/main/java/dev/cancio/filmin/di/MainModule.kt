package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dev.cancio.filmin.core.RetrofitClient
import dev.cancio.filmin.data.service.MovieService

@Module
class MainModule {



    @Provides
    fun provideMovie(): MovieService {
        return RetrofitClient.createService(MovieService::class.java)
    }
}