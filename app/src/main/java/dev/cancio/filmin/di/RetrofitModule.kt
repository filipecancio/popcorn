package dev.cancio.filmin.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dev.cancio.filmin.BuildConfig
import dev.cancio.filmin.ui.activity.HomeActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

    companion object{
        const val RETROFIT = "RETROFIT"
    }

    @Provides
    @Named(RETROFIT)
    fun provideRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor {
                val req = it.request()
                    .newBuilder()
                    .addHeader("Authorization", BuildConfig.API_TOKEN)
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