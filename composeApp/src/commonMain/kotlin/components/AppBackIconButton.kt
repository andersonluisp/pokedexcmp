package components

import androidx.compose.foundation.Image
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.ic_arrow_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppBackIconButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    onClick: () -> Unit = {}
) {
    IconButton(modifier = modifier, onClick = { onClick() }) {
        Image(
            painter = painterResource(Res.drawable.ic_arrow_back),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color, BlendMode.SrcIn)
        )
    }
}