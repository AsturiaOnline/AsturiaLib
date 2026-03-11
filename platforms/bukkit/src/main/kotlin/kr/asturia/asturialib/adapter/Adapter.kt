package kr.asturia.asturialib.adapter

import kr.asturia.asturialib.player.Adventurer
import org.bukkit.OfflinePlayer

object Adapter {
    fun asAdventurer(player: OfflinePlayer): Adventurer = Adventurer(player)
}