package dev.cancio.popcorn.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.cancio.popcorn.BuildConfig
import java.io.Serializable

@Entity
data class Company(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var logoPath: String,
    var country: String,
): Serializable {
    val logo: String
        get() = "${BuildConfig.ASSETS_URL}$logoPath"
}