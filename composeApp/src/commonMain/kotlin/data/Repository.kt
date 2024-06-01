package data

import data.model.Pokemon
import data.model.PokemonDetails
import data.model.PokemonResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class Repository(
    private val service: Ktor,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getPokemonList(): List<Pokemon> {
        return withContext(dispatcher) {
            service.client.get("pokemon").body<PokemonResponse>().pokemons
        }
    }

    suspend fun getPokemon(name: String): PokemonDetails {
        return withContext(dispatcher) {
            service.client.get("pokemon/$name").body<PokemonDetails>()
        }
    }
}