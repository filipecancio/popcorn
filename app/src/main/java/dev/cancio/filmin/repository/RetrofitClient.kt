package dev.cancio.filmin.repository

import dev.cancio.filmin.data.MoviePagination
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitClient {

    @GET("discover/movie")
    fun getMoviesList(@Query("api_key") api_key: String): Call<MoviePagination>

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