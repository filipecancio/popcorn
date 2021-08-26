package dev.cancio.filmin.core

import dev.cancio.filmin.BuildConfig
import dev.cancio.filmin.core.RetrofitClient.Companion.BASE_URL
import dev.cancio.filmin.data.model.MoviePagination
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitClient {

    companion object {

        private const val BASE_URL = BuildConfig.API_URL
        private val retrofitClient: Retrofit by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
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