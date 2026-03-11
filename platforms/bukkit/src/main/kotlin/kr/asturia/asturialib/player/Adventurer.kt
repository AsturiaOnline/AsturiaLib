package kr.asturia.asturialib.player

import kr.asturia.asturialib.data.AdventurerData
import kr.asturia.player.Adventurer
import org.bukkit.OfflinePlayer
import java.util.UUID

class Adventurer(private val player: OfflinePlayer): Adventurer {
    override val uid: UUID
        get() = player.uniqueId
    override val nickname: String
        get() = player.name ?: "Unknown"
    override val display: String
        get() = "" // TODO: Player Custom Display Name if needed

    override fun getState() {}
    override fun setState() {}

    fun getData(): AdventurerData = AdventurerData(this)
}