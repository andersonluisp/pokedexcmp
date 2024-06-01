package components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.pokeball_loading
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppLoadingPokeBall(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing)
        )
    )
    Image(
        modifier = modifier.graphicsLayer {
            rotationZ = angle
        },
        painter = painterResource(Res.drawable.pokeball_loading), alpha = 0.5f,
        contentDescription = null)
}