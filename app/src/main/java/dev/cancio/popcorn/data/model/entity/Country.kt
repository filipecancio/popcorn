package dev.cancio.popcorn.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
)

