package ui.model

data class StatsDataUi(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int
) {
    fun getHpPercentage(): Float {
        return hp.toFloat() / getMaxState().toFloat()
    }

    fun getAttackPercentage(): Float {
        return attack.toFloat() / getMaxState().toFloat()
    }

    fun getDefensePercentage(): Float {
        return defense.toFloat() / getMaxState().toFloat()
    }

    fun getSpeedPercentage(): Float {
        return speed.toFloat() / getMaxState().toFloat()
    }

    private fun getMaxState(): Int {
        return if (maxOf(hp, attack, defense, speed) > 100) {
            maxOf(hp, attack, defense, speed)
        } else 100
    }
}