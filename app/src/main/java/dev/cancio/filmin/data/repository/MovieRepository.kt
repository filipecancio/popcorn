package dev.cancio.filmin.data.repository

import dev.cancio.filmin.core.RetrofitClient
import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Call

class MovieRepository {

    private val movieService = RetrofitClient.createService(MovieService::class.java)

    fun getMoviesList(): Call<MoviePagination> {
        return movieService.getMoviesList()
    }
}