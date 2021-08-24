package dev.cancio.filmin.data.model

import com.google.gson.annotations.SerializedName

data class MoviePagination(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int,
)