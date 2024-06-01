package presentation.navigation

import ui.screen.PokemonListScreen
import ui.viewmodel.MainViewModel
import ui.screen.PokemonDetailScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ui.model.TypeDataUi

object AppNavigation {

    private var navGraphBuilder: NavGraphBuilder? = null

    fun setupNavGraph(
        navGraphBuilder: NavGraphBuilder
    ) {
        println("***AppNavigation | setupNavGraph")
        this.navGraphBuilder = navGraphBuilder
    }

    fun pokemonListDestination(
        navController: NavHostController,
        pokemonViewModel: MainViewModel,
        onPokemonDetailLoaded: (String) -> Unit,
        onNavigate: () -> Unit
    ) {
        println("***AppNavigation | out | pokemonListState.pokemons.size: ${pokemonViewModel.pokemonListState.pokemons.size}")
        navGraphBuilder?.composable("PokemonList") {
            println("***AppNavigation | inside | pokemonListState.pokemons.size: ${pokemonViewModel.pokemonListState.pokemons.size}")
            PokemonListScreen(
                onPokemonClick = {
                    onPokemonDetailLoaded(it.name)
                    navigateToDetailPokemon(navController, it.name, it.types[0].details.name.toUpperCase())
                },
                pokemonViewModel = pokemonViewModel,
            )
            onNavigate()
        }
    }

    fun pokemonDetailDestination(
        pokemonViewModel: MainViewModel,
        onPokemonDetailLoaded: (String) -> Unit,
        onNavigate: (pokemonName: String?) -> Unit
    ) {
        navGraphBuilder?.composable(
            "PokemonDetail/{pokemonName}/{pokemonType}",
            arguments = listOf(
                navArgument("pokemonName") {
                    type = NavType.StringType
                },
                navArgument("pokemonType") {
                    type = NavType.StringType
                }
            )
        ) {
            val pokemonNameState: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonName"
                    )
                )
            }

            val pokemonTypeState: String? by remember {
                mutableStateOf(
                    it.arguments?.getString(
                        "pokemonType"
                    )
                )
            }

            pokemonNameState?.let {
                PokemonDetailScreen(
                    type = TypeDataUi.valueOf(pokemonTypeState ?: "UNKNOWN"),
                    pokemonViewModel = pokemonViewModel,
                    onPokemonEvolutionClick = { pokemonName ->
                        onPokemonDetailLoaded(pokemonName)
                    }
                )
            }
            onNavigate(pokemonNameState)
        }
    }

    private fun navigateToDetailPokemon(
        navController: NavHostController,
        pokemonName: String?,
        pokemonType: String
    ) {
        navController.navigate("PokemonDetail/${pokemonName}/${pokemonType}")
    }
}
