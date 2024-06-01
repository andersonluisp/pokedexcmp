package ui.screen

import ui.viewmodel.MainViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import components.AppTopBar
import presentation.navigation.AppNavigation
import presentation.state.AppBarState

@Composable
fun PokemonMainScreen(
    pokemonViewModel: MainViewModel,
    onSearchValueChanged: (String) -> Unit,
    onPokemonDetailLoaded: (String) -> Unit
) {
    Column {
        var appBarState: AppBarState by remember {
            mutableStateOf(AppBarState(withSearchField = true))
        }
        val navController = rememberNavController()

        PokemonMainAppTopBar(
            appBarState = appBarState,
            navController = navController,
            onClickBack = {
                appBarState = AppBarState(withSearchField = true)
            },
            onSearchValueChanged = onSearchValueChanged
        )
        PokemonMainNavigation(
            navController = navController,
            pokemonViewModel = pokemonViewModel,
            appBarUpdate = { newAppBarState ->
                appBarState = newAppBarState
            },
            onPokemonDetailLoaded = onPokemonDetailLoaded
        )


    }
}

@Composable
fun PokemonMainAppTopBar(
    appBarState: AppBarState,
    navController: NavHostController,
    onClickBack: () -> Unit,
    onSearchValueChanged: (String) -> Unit
) {
    var searchValue: String by rememberSaveable { mutableStateOf("") }

    AppTopBar(
        withSearchField = appBarState.withSearchField,
        withBackIcon = appBarState.withBackButton,
        title = appBarState.title,
        onClickBack = {
            onClickBack()
            navController.navigateUp()
        },
        onSearchValueChanged = {
            onSearchValueChanged(it)
            searchValue = it
        },
        searchValue = searchValue
    )
}

@Composable
fun PokemonMainNavigation(
    navController: NavHostController,
    pokemonViewModel: MainViewModel,
    appBarUpdate: (AppBarState) -> Unit,
    onPokemonDetailLoaded: (String) -> Unit
) {
    NavHost(navController = navController, startDestination = "PokemonList") {

        AppNavigation.setupNavGraph(this)

        AppNavigation.pokemonListDestination(
            navController,
            pokemonViewModel,
            onPokemonDetailLoaded
        ) {
            appBarUpdate(AppBarState(withSearchField = true))
        }

        AppNavigation.pokemonDetailDestination(
            pokemonViewModel,
            onPokemonDetailLoaded
        ) {
            appBarUpdate(AppBarState(withBackButton = true, title = it))
        }
    }

}