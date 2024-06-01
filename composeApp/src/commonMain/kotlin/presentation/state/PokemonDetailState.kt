package presentation.state

import data.model.PokemonDetails

data class PokemonDetailState(
    val pokemon: PokemonDetails? = null,
    val loading: Boolean = false,
    val error: Throwable? = null
)