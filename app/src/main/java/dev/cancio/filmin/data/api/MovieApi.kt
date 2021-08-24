package dev.cancio.filmin.data.api

import dev.cancio.filmin.core.RetrofitClient
import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Call

class MovieApi {

    private val movieService = RetrofitClient.createService(MovieService::class.java)

    fun getMoviesList(api_key: String): Call<MoviePagination> {
        return movieService.getMoviesList(api_key)
    }
}