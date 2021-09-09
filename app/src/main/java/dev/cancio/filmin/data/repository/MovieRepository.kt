package dev.cancio.filmin.data.repository

import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Call
import javax.inject.Inject

class MovieRepository @Inject constructor(val movieService: MovieService) {

    fun getMoviesList(): Call<MoviePagination> {
        return movieService.getMoviesList()
    }
}