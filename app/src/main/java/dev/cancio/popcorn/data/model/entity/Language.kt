package dev.cancio.popcorn.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Language(
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var name: String,
    var englishName: String,
)

