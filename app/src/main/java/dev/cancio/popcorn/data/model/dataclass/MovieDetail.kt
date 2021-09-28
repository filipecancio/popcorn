package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName
import dev.cancio.popcorn.BuildConfig
import dev.cancio.popcorn.data.model.entity.Movie
import dev.cancio.popcorn.data.model.enum.DetailStatus
import java.io.Serializable

data class MovieDetail(
    var adult: Boolean,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    @SerializedName("belongs_to_collection")
    var collectionResponse: CollectionResponse?,
    var budget: Int,
    var genreResponses: List<GenreResponse>,
    var homepage: String,
    var id: Int,
    @SerializedName("imdb_id")
    var imdbId: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("original_title")
    var originalTitle: String,
    var overview: String,
    var popularity: Double,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("production_companies")
    var companyResponses: List<CompanyResponse>,
    @SerializedName("production_countries")
    var countryResponses: List<CountryResponse>,
    @SerializedName("release_date")
    var releaseDate: String,
    var revenue: Int,
    var runtime: Int,
    @SerializedName("spoken_languages")
    var languageResponses: List<LanguageResponse>,
    var status: DetailStatus,
    var tagline: String,
    var title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Double =0.0,
    @SerializedName("voteCount")
    var voteCount: Int =0,
): Serializable {

    val poster: String
        get() = "${BuildConfig.ASSETS_URL}$posterPath"

    val backdrop: String
        get() = "${BuildConfig.ASSETS_URL}$backdropPath"

    fun toEntity() = Movie(
        backdropPath = this.backdropPath,
        id = this.id,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        title = this.title,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}