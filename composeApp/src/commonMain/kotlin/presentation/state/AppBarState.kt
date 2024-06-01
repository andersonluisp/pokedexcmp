package presentation.state

data class AppBarState(
    val withSearchField: Boolean = false,
    val withBackButton: Boolean = false,
    val title: String? = null
)