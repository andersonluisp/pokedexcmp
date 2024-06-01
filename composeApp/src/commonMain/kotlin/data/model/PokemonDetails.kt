package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetails(
    @SerialName("name")
    val name: String,
    @SerialName("sprites")
    val sprites: Sprites,
    @SerialName("types")
    val types: List<Type>,
    @SerialName("stats")
    val stats: List<Stat>
)

@Serializable
data class Sprites(
    @SerialName("other")
    val otherSprites: OtherSprites
)

@Serializable
data class OtherSprites(
    @SerialName("dream_world")
    val dreamWorldSprites: DreamWorldSprites
)

@Serializable
data class DreamWorldSprites(
    @SerialName("front_default")
    val imageUrl: String
)


@Serializable
data class Type(
    @SerialName("type")
    val details: TypeDetails
)

@Serializable
data class TypeDetails(
    @SerialName("name")
    val name: String
)

@Serializable
data class Stat(
    @SerialName("base_stat")
    val baseStat: Int,
    @SerialName("stat")
    val details: StatDetails
)

@Serializable
data class StatDetails(
    @SerialName("name")
    val name: String,
)

