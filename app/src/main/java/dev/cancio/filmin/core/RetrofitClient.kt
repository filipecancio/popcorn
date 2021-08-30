package dev.cancio.filmin.core

import dev.cancio.filmin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private const val BASE_URL = BuildConfig.API_URL
        private const val BASE_TOKEN = BuildConfig.API_TOKEN
        
        private val retrofitClient: Retrofit by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor {
                            val req = it.request()
                                .newBuilder()
                                .addHeader("Authorization", BASE_TOKEN)
                                .build()
                            it.proceed(req)
                        }
                        .addInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        )
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit
        }

        private fun getInstance(): Retrofit {
            return retrofitClient
        }

        fun <T> createService(servClass: Class<T>):T {
            return getInstance().create(servClass)
        }
    }
}
