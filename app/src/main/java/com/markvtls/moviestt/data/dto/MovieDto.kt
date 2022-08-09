package com.markvtls.moviestt.data.dto

import com.markvtls.moviestt.domain.model.MovieDomain

data class Movie(
    val title: String,
    val directorName: String,
    val releaseYear: Int,
    val actors: List<Actor>
)

data class Response(
    val items: List<Movie>
)
data class Actor(
    val actorName: String
)

fun Movie.toDomain(): MovieDomain {
    val cast = mutableSetOf<String>()
    val directorNameInitial: String
    actors.forEach { actor ->
        cast.add(actor.actorName)
    }
    val directorNames = directorName.split(" ")
    directorNameInitial = "${directorNames[2]} ${directorNames[0][0]}. ${directorNames[1][0]}."
    return MovieDomain(
        title = title,
        directorName = directorNameInitial,
        releaseYear = releaseYear,
        actors = cast.joinToString("\n")
    )
}