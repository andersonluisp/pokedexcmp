import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import ui.screen.PokemonMainScreen
import ui.viewmodel.MainViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val viewModel = koinViewModel<MainViewModel>()
            PokemonMainScreen(
                pokemonViewModel = viewModel,
                onSearchValueChanged = {viewModel.onSearchValueChanged(it) },
                onPokemonDetailLoaded = { viewModel.getPokemonDetail(it) }
            )


//            NavHost(
//                navController = navController,
//                startDestination = "FirstScreen"
//            ) {
//                composable(route = "FirstScreen") {
//                    val viewModel = koinViewModel<ui.viewmodel.MainViewModel>()
//                    val timer by viewModel.timer.collectAsState()
//                    PokemonListScreen(
//                        onPokemonClick = {
//                            navController.navigate("SecondScreen")
//                        },
//                        pokemonList = viewModel.pokemons,
//                    )
//                }
//
//                composable(route = "SecondScreen") {
//                    PokemonDetailScreen(
//                        onButtonClick = { navController.navigateUp() }
//                    )
//                }
//            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}
