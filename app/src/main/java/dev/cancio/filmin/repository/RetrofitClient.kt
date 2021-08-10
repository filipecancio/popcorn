package dev.cancio.filmin.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitClient {

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private val retrofitClient: RetrofitClient by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(retrofitClient::class.java)

        }

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }
}