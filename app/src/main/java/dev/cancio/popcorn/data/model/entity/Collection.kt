package dev.cancio.popcorn.data.model.entity

import androidx.room.PrimaryKey
import dev.cancio.popcorn.BuildConfig
import java.io.Serializable

data class Collection(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String?,
    var posterPath: String?,
    var backdropPath: String?
): Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"

}