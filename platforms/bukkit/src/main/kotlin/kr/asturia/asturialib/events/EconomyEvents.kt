package kr.asturia.asturialib.events

import kr.asturia.api.player.Adventurer
import kr.asturia.asturialib.utilities.getPlayer
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

class EconomyPlayerWithdrawEvent(
    adventurer: Adventurer,
    val amount: Double,
    val reason: String
): PlayerEvent(adventurer.getPlayer().player ?: error("Cant find the player")) {
    override fun getEventName() = "EconomyPlayerWithdrawEvent"
    override fun getHandlers(): HandlerList = getHandlerList()
    companion object {
        private val handlers = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlers
        }
    }
}

class EconomyPlayerDispositEvent(
    adventurer: Adventurer,
    val amount: Double,
    val reason: String
): PlayerEvent(adventurer.getPlayer().player ?: error("Cant find the player")) {
    override fun getEventName() = "EconomyPlayerDispositEvent"
    override fun getHandlers(): HandlerList = getHandlerList()
    companion object {
        private val handlers = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlers
        }
    }
}