package dev.cancio.popcorn.data.model.relationship

import androidx.room.Embedded
import androidx.room.Relation
import dev.cancio.popcorn.data.model.entity.Language
import dev.cancio.popcorn.data.model.entity.Movie

data class MovieWithLanguages(
    @Embedded
    val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    private val languageResponses: List<Language>,
)

