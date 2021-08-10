package dev.cancio.filmin.data

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    val adult: Boolean,
    val video: Boolean,
    val overview: String,
    val popularity: Double,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
)