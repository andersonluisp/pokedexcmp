package ui.model

import androidx.compose.ui.graphics.Color
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.bug
import pokedex.composeapp.generated.resources.dark
import pokedex.composeapp.generated.resources.dragon
import pokedex.composeapp.generated.resources.electric
import pokedex.composeapp.generated.resources.fairy
import pokedex.composeapp.generated.resources.fighting
import pokedex.composeapp.generated.resources.fire
import pokedex.composeapp.generated.resources.flying
import pokedex.composeapp.generated.resources.ghost
import pokedex.composeapp.generated.resources.grass
import pokedex.composeapp.generated.resources.ground
import pokedex.composeapp.generated.resources.ice
import pokedex.composeapp.generated.resources.normal
import pokedex.composeapp.generated.resources.poison
import pokedex.composeapp.generated.resources.psychic
import pokedex.composeapp.generated.resources.rock
import pokedex.composeapp.generated.resources.steel
import pokedex.composeapp.generated.resources.water
import org.jetbrains.compose.resources.DrawableResource
import ui.theme.*

enum class TypeDataUi(
    val typeName: String,
    val typeIcon: DrawableResource?,
    val backgroundColor: Color
) {
    NORMAL(typeName = "Normal", typeIcon = Res.drawable.normal, backgroundColor = NORMAL_COLOR),
    FIGHTING(typeName = "Fighting", typeIcon = Res.drawable.fighting, backgroundColor = FIGHTING_COLOR),
    FLYING(typeName = "Flying", typeIcon = Res.drawable.flying, backgroundColor = FLYING_COLOR),
    POISON(typeName = "Poison", typeIcon = Res.drawable.poison, backgroundColor = POISON_COLOR),
    GROUND(typeName = "Ground", typeIcon = Res.drawable.ground, backgroundColor = GROUND_COLOR),
    ROCK(typeName = "Rock", typeIcon = Res.drawable.rock, backgroundColor = ROCK_COLOR),
    BUG(typeName = "Bug", typeIcon = Res.drawable.bug, backgroundColor = BUG_COLOR),
    GHOST(typeName = "Ghost", typeIcon = Res.drawable.ghost, backgroundColor = GHOST_COLOR),
    STEEL(typeName = "Steel", typeIcon = Res.drawable.steel, backgroundColor = STEEL_COLOR),
    FIRE(typeName = "Fire", typeIcon = Res.drawable.fire, backgroundColor = FIRE_COLOR),
    WATER(typeName = "Water", typeIcon = Res.drawable.water, backgroundColor = WATER_COLOR),
    GRASS(typeName = "Grass", typeIcon = Res.drawable.grass, backgroundColor = GRASS_COLOR),
    ELECTRIC(typeName = "Electric", typeIcon = Res.drawable.electric, backgroundColor = ELECTRIC_COLOR),
    PSYCHIC(typeName = "Psychic", typeIcon = Res.drawable.psychic, backgroundColor = PSYCHIC_COLOR),
    ICE(typeName = "Ice", typeIcon = Res.drawable.ice, backgroundColor = ICE_COLOR),
    DRAGON(typeName = "Dragon", typeIcon = Res.drawable.dragon, backgroundColor = DRAGON_COLOR),
    DARK(typeName = "Dark", typeIcon = Res.drawable.dark, backgroundColor = DARK_COLOR),
    FAIRY(typeName = "Fairy", typeIcon = Res.drawable.fairy, backgroundColor = FAIRY_COLOR),
    UNKNOWN(typeName = "Unknown", typeIcon = null, backgroundColor = UNKNOWN_COLOR),
    SHADOW(typeName = "Shadow", typeIcon = null, backgroundColor = SHADOW_COLOR),
}