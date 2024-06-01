package components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.roboto_bold_font
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppPokemonType(
    icon: DrawableResource?,
    typeName: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(icon),
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = typeName,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(Res.font.roboto_bold_font))
        )
    }
}
