package dev.cancio.popcorn.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Language(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val englishName: String,
)

