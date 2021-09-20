package dev.cancio.popcorn.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genre(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)
