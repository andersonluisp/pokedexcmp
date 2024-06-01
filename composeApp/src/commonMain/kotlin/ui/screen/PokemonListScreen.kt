package ui.screen

import ui.viewmodel.MainViewModel
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.AppLoadingPokeBall
import components.AppPokemonCard
import data.model.PokemonDetails
import ui.model.TypeDataUi

@Composable
fun PokemonListScreen(
    pokemonViewModel: MainViewModel,
    onPokemonClick: (PokemonDetails) -> Unit,
) {

    val pokemonListState = pokemonViewModel.pokemonListState

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val fadeIn = fadeIn(initialAlpha = 0F)
        val scaleIn = scaleIn(initialScale = 0F)

        if (pokemonListState.loading) {
            AppLoadingPokeBall(modifier = Modifier.size(128.dp))
        }

        println("***PokemonListScreen | Box: ${pokemonListState.pokemons.size}")

        androidx.compose.animation.AnimatedVisibility(
            visible = pokemonListState.error == null && pokemonListState.loading.not(),
            enter = fadeIn + scaleIn
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxHeight(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                println("***PokemonListScreen | Pokemons: ${pokemonListState.pokemons.size}")
                items(pokemonListState.pokemons) { pokemon ->
                        AppPokemonCard(
                            modifier = Modifier.clickable {
                                onPokemonClick(pokemon)
                            },
                            name = pokemon.name,
                            imageUrl = pokemon.sprites.otherSprites.dreamWorldSprites.imageUrl,
                            types = pokemon.types.map { type ->
                                TypeDataUi.valueOf(type.details.name.toUpperCase())
                            }
                        )
                    }
            }
        }
    }
}