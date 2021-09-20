package dev.cancio.popcorn.data.model.dataclass

import com.google.gson.annotations.SerializedName
import dev.cancio.popcorn.BuildConfig
import java.io.Serializable

data class CompanyResponse(
    val id: Int,
    val name: String,
    @SerializedName("logo_path")
    private val logoPath: String,
    @SerializedName("origin_country")
    private val country: String,
):Serializable{
    val logo: String
        get() = "${BuildConfig.ASSETS_URL}$logoPath"
}