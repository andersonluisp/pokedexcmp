package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.roboto_bold_font
import org.jetbrains.compose.resources.Font
import ui.model.TypeDataUi

@Composable
fun AppPokemonCardNameType(
    pokemonName: String,
    types: List<TypeDataUi>
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(
                alpha = 0.5f
            )
        )
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = pokemonName,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(Res.font.roboto_bold_font))
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    types.forEachIndexed { index, typeDataUi ->
                        if (index <= 1) {
                            AppPokemonType(
                                icon = typeDataUi.typeIcon,
                                typeName = typeDataUi.typeName
                            )
                        }
                    }
                }
            }
        }
    }
}