package dev.cancio.filmin.data.repository

import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import dev.cancio.popcorn.data.model.dataclass.MoviePagination
import dev.cancio.popcorn.data.service.MovieService
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getMoviesList(): Response<MoviePagination> {
        return movieService.getMoviesList().awaitResponse()
    }

    suspend fun getMovieDetail(movieId: Int): Response<MovieDetail> {
        return movieService.getMovieDetail(movieId).awaitResponse()
    }

    suspend fun getMovieCredits(movieId: Int): Response<Credit> {
        return movieService.getMovieCredits(movieId).awaitResponse()
    }

    suspend fun getMovieSearch(movieName: String): Response<MoviePagination> {
        return movieService.getMovieSearch(movieName).awaitResponse()
    }
}