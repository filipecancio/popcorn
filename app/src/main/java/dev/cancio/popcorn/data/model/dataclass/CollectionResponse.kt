package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName
import dev.cancio.popcorn.BuildConfig
import dev.cancio.popcorn.data.model.entity.Collection
import java.io.Serializable

data class CollectionResponse(
    val id: Int,
    val name: String,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("backdrop_path")
    private val backdropPath: String
): Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"

    fun toEntity() = Collection(
        id,
        name,
        posterPath,
        backdropPath
    )
}
