package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Retrofit
import javax.inject.Named

@Module
class MainModule {

    @Provides
    fun provideMovie(@Named(RetrofitModule.RETROFIT) retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}