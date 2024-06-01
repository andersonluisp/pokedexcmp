package presentation.state

import data.model.PokemonDetails

data class PokemonListState(
    val pokemons: List<PokemonDetails> = emptyList(),
    val loading: Boolean = false,
    val error: Throwable? = null
)