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
    private val collectionResponse: CollectionResponse?,
    val budget: Int,
    val genreResponses: List<GenreResponse>,
    val homepage: String,
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("production_companies")
    private val companyResponses: List<CompanyResponse>,
    @SerializedName("production_countries")
    private val countryResponses: List<CountryResponse>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    private val languageResponses: List<LanguageResponse>,
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