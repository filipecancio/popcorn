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
    var voteCount: Int,
    var voteAverage: Double,
    var popularity: Double,
    var backdropPath: String?,
    var overview: String?,
    var posterPath: String?,
    var title: String?,
    @Embedded(prefix = "collection_") var collection: Collection?,
) : Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"
}