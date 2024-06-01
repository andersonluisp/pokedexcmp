package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.preview_pokemon
import org.jetbrains.compose.resources.painterResource
import ui.model.TypeDataUi
import ui.theme.GRASS_COLOR

@Composable
fun AppPokemonCard(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    types: List<TypeDataUi> = emptyList()
) {
//    Column {
//        AsyncImage(
//            modifier = Modifier.size(200.dp),
//            model = ImageRequest.Builder(LocalPlatformContext.current)
//                .data(imageUrl)
//                .decoderFactory(SvgDecoder.Factory())
//                .build(),
//            contentDescription = name
//        )
//        Spacer(Modifier.size(16.dp))
//        Text(text = name)
//    }

    // new component

    val backgroundColor = types[0].backgroundColor
    AppGradientBackgroundPokemonCard(
        modifier = modifier,
        backgroundColor = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppPokemonWithShadowImage(imageUrl = imageUrl)
            AppPokemonCardNameType(pokemonName = name, types = types)
        }
    }
}