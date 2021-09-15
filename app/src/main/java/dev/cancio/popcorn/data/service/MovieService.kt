package dev.cancio.popcorn.data.service

import dev.cancio.popcorn.data.model.MoviePagination
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie")
    fun getMoviesList(): Call<MoviePagination>
}