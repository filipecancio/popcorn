package dev.cancio.popcorn.data.repository

import dev.cancio.popcorn.data.dao.PopCornDao
import dev.cancio.popcorn.data.model.entity.Movie
import javax.inject.Inject

class LikeMovieRepository @Inject constructor(
    private val popCornDao: PopCornDao
) {

    fun getLikedMovies() = popCornDao.getMovies()

    suspend fun likeMovie(movie: Movie) = popCornDao.createMovie(movie)

    suspend fun unlikeMovie(movieId: Int) = popCornDao.removeMovie(movieId)
}