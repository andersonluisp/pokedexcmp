package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: (String) -> Unit = {},
    searchValue: String = ""
) {
    var text: String by rememberSaveable { mutableStateOf(searchValue) }

    BasicTextField(modifier = modifier
        .background(
            Color.White,
            MaterialTheme.shapes.small,
        )
        .fillMaxWidth()
        .padding(8.dp),
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = MaterialTheme.typography.bodySmall.fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(Res.drawable.ic_search),
                    tint = Color.Black,
                    contentDescription = null
                )
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                ) {
                    if (text.isEmpty()) Text(
                        label,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                    )
                    innerTextField()
                }
            }
        }
    )
}