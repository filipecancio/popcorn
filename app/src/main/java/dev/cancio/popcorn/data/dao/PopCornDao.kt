package dev.cancio.popcorn.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.cancio.popcorn.data.model.entity.Movie

@Dao
interface PopCornDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun removeMovie(id:Int)

    @Query("SELECT * FROM Movie WHERE id = :id")
    suspend fun getMovie(id:Int): Movie?

    @Query("SELECT * FROM Movie")
    suspend fun getMovieList(): List<Movie>
}