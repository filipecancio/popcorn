package dev.cancio.popcorn.data.service

import dev.cancio.popcorn.data.model.dataclass.Credit
import dev.cancio.popcorn.data.model.dataclass.MovieDetail
import dev.cancio.popcorn.data.model.dataclass.MoviePagination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun getMoviesList(): Call<MoviePagination>

    @GET("movie/{movieId}")
    fun getMovieDetail(@Path("movieId") movieId: Int): Call<MovieDetail>

    @GET("movie/{movieId}/credits")
    fun getMovieCredits(@Path("movieId") movieId: Int): Call<Credit>

    @GET("search/movie")
    fun getMovieSearch(@Query("query") query: String): Call<MoviePagination>
}