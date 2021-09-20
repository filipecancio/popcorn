package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("iso_3166_1")
    val id: String,
    val name: String,
)
