package dev.cancio.popcorn.data.model.enum

enum class DetailStatus(val value: String) {
    RUMORED("Rumored"),
    PLANNED("Planned"),
    IN_PRODUCTION("In Production"),
    POST_PRODUCTION("Post Production"),
    RELEASED("Released"),
    CANCELED("Canceled")
}