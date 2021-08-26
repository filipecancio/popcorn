package dev.cancio.filmin.data.service

import dev.cancio.filmin.data.model.MoviePagination
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie")
    fun getMoviesList(): Call<MoviePagination>
}