package dev.cancio.popcorn.data.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.cancio.popcorn.BuildConfig
import java.io.Serializable

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var budget: Int,
    var revenue: Int,
    var runtime: Int,
    var voteCount: Int,
    var voteAverage: Double,
    var popularity: Double,
    var adult: Boolean,
    var video: Boolean,
    var backdropPath: String?,
    var homepage: String?,
    var imdbId: String?,
    var originalLanguage: String?,
    var originalTitle: String?,
    var overview: String?,
    var releaseDate: String,
    var posterPath: String?,
    var tagline: String?,
    var title: String?,
    @Embedded(prefix = "collection_") var collection: Collection?,
) : Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"
}