package dev.cancio.popcorn.data.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.cancio.popcorn.BuildConfig
import dev.cancio.popcorn.data.model.dataclass.CollectionResponse
import dev.cancio.popcorn.data.model.enum.DetailStatus
import java.io.Serializable

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val budget: Int,
    val revenue: Int,
    val runtime: Int,
    val voteCount: Int,
    val voteAverage: Double,
    val popularity: Double,
    val adult: Boolean,
    val video: Boolean,
    private val backdropPath: String,
    val homepage: String,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    private val posterPath: String,
    val tagline: String,
    val title: String,
    @Embedded val status: DetailStatus,
    @Embedded private val collectionResponse: CollectionResponse?,
) : Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"
}