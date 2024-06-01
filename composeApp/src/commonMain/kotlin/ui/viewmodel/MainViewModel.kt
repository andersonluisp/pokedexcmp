package ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.Repository
import data.model.Pokemon
import data.model.PokemonDetails
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import presentation.state.PokemonDetailState
import presentation.state.PokemonListState

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _timer = MutableStateFlow(0)
    val timer = _timer.asStateFlow()

    private val _pokemons = mutableStateListOf<Pokemon>()
    val pokemons: SnapshotStateList<Pokemon> = _pokemons

    var pokemonListState by mutableStateOf(PokemonListState())
    private var defaultPokemonList: List<PokemonDetails> = emptyList()

    var pokemonDetailState by mutableStateOf(PokemonDetailState())

    init {
        startTimer()
        getPokemons()
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (timer.value < 5) {
                delay(1000)
                _timer.value++
            }
        }
    }

    fun getPokemons() {
        updatePokemonListState(loading = true)
        viewModelScope.launch {
            val pokemons = runCatching { repository.getPokemonList() }
                .onFailure {
                    updatePokemonListState(error = it, loading = false)
                }.getOrDefault(emptyList())
            pokemons.forEach {
                val pokemon = runCatching { repository.getPokemon(it.name) }
                    .onFailure { }.getOrDefault(null)
                it.details = pokemon
            }
            println("***ViewModel after pokemons.forEach")
            val pokemonsList = pokemons.mapNotNull { it.details }
            defaultPokemonList = pokemonsList
            updatePokemonListState(
                pokemons = pokemonsList,
                loading = false
            )
            _pokemons.addAll(pokemons)
        }
    }


    private fun updatePokemonListState(
        pokemons: List<PokemonDetails> = emptyList(),
        loading: Boolean = false,
        error: Throwable? = null,
    ) {
        println("***Viewmodel | updatePokemonListState | pokemons.size: ${pokemons.size} | loading: $loading | error: $error")
        pokemonListState = pokemonListState.copy(
            pokemons = pokemons,
            loading = loading,
            error = error
        )
    }

    fun getPokemonDetail(name: String) {
        updatePokemonDetailState(loading = true)
        viewModelScope.launch {
            runCatching { repository.getPokemon(name) }
                .onSuccess { pokemon ->
                    updatePokemonDetailState(pokemon, loading = false)
                }
                .onFailure { throwable ->
                    updatePokemonDetailState(error = throwable, loading = false)
                }
        }
    }

    private fun updatePokemonDetailState(
        pokemon: PokemonDetails? = null,
        loading: Boolean = false,
        error: Throwable? = null
    ) {
        pokemonDetailState = pokemonDetailState.copy(
            pokemon = pokemon,
            loading = loading,
            error = error
        )
    }

    fun onSearchValueChanged(query: String) {
        if (query.isEmpty()) {
            updatePokemonListState(pokemons = defaultPokemonList)
        } else {
            val newPokemonList = defaultPokemonList.filter { it.doesMatchSearchQuery(query) }
            updatePokemonListState(pokemons = newPokemonList)
        }
    }

    fun PokemonDetails.doesMatchSearchQuery(query: String): Boolean {
        return name.contains(query, ignoreCase = true)
    }
}