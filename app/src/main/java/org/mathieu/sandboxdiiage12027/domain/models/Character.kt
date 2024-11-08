package org.mathieu.sandboxdiiage12027.domain.models

import androidx.compose.ui.graphics.Color


data class Character(
    val id: Long,
    val name: String,
    val status: LivingStatus,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)

enum class LivingStatus {
    Unknown, Dead, Alive
}


data class Location(
    val name: String,
    val url: String,
)

val charactersMock = listOf(
    Character(
        id = 219,
        name = "Mechanical Summer",
        status = LivingStatus.Unknown,
        species = "Robot",
        type = "",
        gender = "Female",
        origin = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        location = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/219.jpeg",
        episode = listOf(
            "https://rickandmortyapi.com/api/episode/23"
        ),
        url = "https://rickandmortyapi.com/api/character/219",
        created = "2017-12-30T14:33:49.392Z"

    ),
    Character(
        id = 1,
        name = "Rick Sanchez",
        status = LivingStatus.Alive,
        species = "Human",
        type = "",
        gender = "Male",
        origin = Location(
            name = "Earth (C-137)",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = Location(
            name = "Citadel of Ricks",
            url = "https://rickandmortyapi.com/api/location/3"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/1",
        created = "2017-11-04T18:48:46.250Z"
    ),
    Character(
        id = 2,
        name = "Morty Smith",
        status = LivingStatus.Alive,
        species = "Human",
        type = "",
        gender = "Male",
        origin = Location(
            name = "unknown",
            url = ""
        ),
        location = Location(
            name = "Citadel of Ricks",
            url = "https://rickandmortyapi.com/api/location/3"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/2",
        created = "2017-11-04T18:50:21.651Z"
    ),
    Character(
        id = 3,
        name = "Summer Smith",
        status = LivingStatus.Alive,
        species = "Human",
        type = "",
        gender = "Female",
        origin = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        location = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/3",
        created = "2017-11-04T19:09:56.428Z"
    ),
    Character(
        id = 4,
        name = "Beth Smith",
        status = LivingStatus.Alive,
        species = "Human",
        type = "",
        gender = "Female",
        origin = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        location = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/4",
        created = "2017-11-04T19:22:43.665Z"
    ),
    Character(
        id = 5,
        name = "Jerry Smith",
        status = LivingStatus.Alive,
        species = "Human",
        type = "",
        gender = "Male",
        origin = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        location = Location(
            name = "Earth (Replacement Dimension)",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/5",
        created = "2017-11-04T19:26:56.301Z"
    ),
    Character(
        id = 6,
        name = "Abadango Cluster Princess",
        status = LivingStatus.Alive,
        species = "Alien",
        type = "",
        gender = "Female",
        origin = Location(
            name = "Abadango",
            url = "https://rickandmortyapi.com/api/location/2"
        ),
        location = Location(
            name = "Abadango",
            url = "https://rickandmortyapi.com/api/location/2"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/6.jpeg",
        episode = emptyList(),
        url = "https://rickandmortyapi.com/api/character/6",
        created = "2017-11-04T19:50:28.250Z"
    )
    // Add more characters if needed
)
