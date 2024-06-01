package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.pokemon_shadow
import pokedex.composeapp.generated.resources.preview_pokemon
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppPokemonWithShadowImage(
    imageUrl: String
) {
    val isPreview = LocalInspectionMode.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(116.dp),
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(imageUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            placeholder = if (isPreview) painterResource(Res.drawable.preview_pokemon) else null
        )
        Image(
            painter = painterResource(Res.drawable.pokemon_shadow),
            contentDescription = null
        )
    }

}