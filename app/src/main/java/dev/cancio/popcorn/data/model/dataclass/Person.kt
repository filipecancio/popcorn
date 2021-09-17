package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName
import dev.cancio.popcorn.BuildConfig
import dev.cancio.popcorn.data.model.enum.PersonGender
import java.io.Serializable

data class Person(
    val adult: Boolean,
    val gender: PersonGender,
    val id: Int,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    val popularity: Double,
    @SerializedName("profile_path")
    private val profilePath: String,
    @SerializedName("cast_id")
    private val castId: Int?,
    private val character: String,
    @SerializedName("credit_id")
    private val creditId: String,
    private val order: Int?,
    private val department: String?,
): Serializable {
    val avatar: String
        get() = "${BuildConfig.ASSETS_URL}$profilePath"
}