package dev.cancio.filmin.data.repository

import dev.cancio.filmin.data.model.MoviePagination
import dev.cancio.filmin.data.service.MovieService
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getMoviesList(): Response<MoviePagination> {
        return movieService.getMoviesList().awaitResponse()
    }
}