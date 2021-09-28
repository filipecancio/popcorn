package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName

data class MoviePagination(
    val page: Int,
    val results: List<MovieResponse>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int,
)