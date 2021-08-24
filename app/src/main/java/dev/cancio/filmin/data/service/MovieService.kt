package dev.cancio.filmin.data.service

import dev.cancio.filmin.data.model.MoviePagination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun getMoviesList(@Query("api_key") api_key: String): Call<MoviePagination>
}