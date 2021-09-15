package dev.cancio.popcorn.di

import dagger.Module
import dagger.Provides
import dev.cancio.popcorn.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    companion object{
        private const val AUTHORIZATION = "Authorization"
    }

    @Provides
    fun provideRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor {
                val req = it.request()
                    .newBuilder()
                    .addHeader(AUTHORIZATION, BuildConfig.API_TOKEN)
                    .build()
                it.proceed(req)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client( client )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}