package dev.cancio.popcorn.data.repository

import dev.cancio.popcorn.core.RetrofitClient
import dev.cancio.popcorn.data.model.MoviePagination
import dev.cancio.popcorn.data.service.MovieService
import retrofit2.Call

class MovieRepository {

    private val movieService = RetrofitClient.createService(MovieService::class.java)

    fun getMoviesList(): Call<MoviePagination> {
        return movieService.getMoviesList()
    }
}