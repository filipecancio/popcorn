package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName
import dev.cancio.popcorn.BuildConfig
import dev.cancio.popcorn.data.model.enum.DetailStatus
import java.io.Serializable

data class MovieDetail(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    private val backdropPath: String,
    @SerializedName("belongs_to_collection")
    private val collection: MovieCollection?,
    val budget: Int,
    val genres: List<MovieGenre>,
    val homepage: String,
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("production_companies")
    private val companies: List<MovieCompany>,
    @SerializedName("production_countries")
    private val countries: List<Country>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    private val languages: List<Language>,
    val status: DetailStatus,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("voteCount")
    val voteCount: Int,
): Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"
}