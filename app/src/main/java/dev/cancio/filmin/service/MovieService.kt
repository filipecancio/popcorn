package dev.cancio.filmin.service

import dev.cancio.filmin.data.MoviePagination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun getMoviesList(@Query("api_key") api_key: String): Call<MoviePagination>
}