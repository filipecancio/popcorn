package dev.cancio.popcorn.data.model.dataclass

data class Credit(
    val id: Int,
    val cast: List<Person>,
    val crew: List<Person>,
)
