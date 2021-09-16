package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("iso_3166_1")
    val id: Int,
    val name: String,
)
