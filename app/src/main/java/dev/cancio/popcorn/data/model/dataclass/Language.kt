package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("iso_639_1")
    val id: Int,
    val name: String,
    @SerializedName("english_name")
    val englishName: String,
)
