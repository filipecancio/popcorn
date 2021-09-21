package dev.cancio.popcorn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.cancio.popcorn.data.model.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface PopCornDao {

    @Insert
    suspend fun createMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun removeMovie(id:Int)

    @Query("SELECT * FROM Movie")
    fun getMovies(): Flow<List<Movie>>

}