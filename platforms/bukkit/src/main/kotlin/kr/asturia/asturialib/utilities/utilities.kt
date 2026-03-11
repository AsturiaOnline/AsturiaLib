package kr.asturia.asturialib.utilities

import kr.asturia.api.player.Adventurer
import org.bukkit.Bukkit
import org.bukkit.event.Event
import java.util.UUID

fun Adventurer.getPlayer() = Bukkit.getOfflinePlayer(this.uid)
fun Event.call() = Bukkit.getPluginManager().callEvent(this)

fun String.toPlayer() = Bukkit.getPlayer(this)
fun UUID.toPlayer() = Bukkit.getPlayer(this)
@Deprecated("Use toPlayer() instead", ReplaceWith("toPlayer()"))
fun String.toOfflinePlayer() = Bukkit.getOfflinePlayer(this)
fun UUID.toOfflinePlayer() = Bukkit.getOfflinePlayer(this)