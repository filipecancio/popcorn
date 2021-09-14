package dev.cancio.popcorn.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Movie(
    val id: Int,
    val title: String,
    val adult: Boolean,
    val video: Boolean,
    val overview: String,
    val popularity: Double,
    @SerializedName("backdrop_path")
    private val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("voteCount")
    val voteCount: Int,
):Serializable {

    val poster: String
        get() = "${BASE_URL}$posterPath"

    val backdrop: String
        get() = "${BASE_URL}$backdropPath"

    companion object {
        private const val BASE_URL = "https://image.tmdb.org/t/p/original"
    }
}