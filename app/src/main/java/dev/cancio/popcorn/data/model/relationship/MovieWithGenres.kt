package dev.cancio.popcorn.data.model.relationship

import androidx.room.Embedded
import androidx.room.Relation
import dev.cancio.popcorn.data.model.entity.Genre
import dev.cancio.popcorn.data.model.entity.Movie

data class MovieWithGenres(
    @Embedded
    val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val genreResponses: List<Genre>,
    )
