package kr.asturia.asturialib

import kr.asturia.asturialib.adapter.Adapter
import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.java.JavaPlugin

class AsturiaLib: JavaPlugin() {
    companion object {
        @JvmStatic
        lateinit var instance: AsturiaLib
            private set
        @JvmStatic
        lateinit var adapter: Adapter
            private set
        @JvmStatic
        lateinit var econ: Economy
            private set
    }

    override fun onLoad() {
        instance=this
        adapter = Adapter
        saveDefaultConfig()
    }

    override fun onEnable() {


        // Economy
        server.servicesManager.register(
            Economy::class.java,
            kr.asturia.asturialib.economy.Economy(),
            this,
            org.bukkit.plugin.ServicePriority.Normal
        )
        if (!setupEconomy()) {
            logger.warning("Vault 플러그인을 찾을 수 없습니다")
            this.server.pluginManager.disablePlugin(this)
            return
        }
    }

    override fun onDisable() {

    }

    private fun setupEconomy(): Boolean {
        val vaultPlugin = server.pluginManager.getPlugin("Vault")
        if (vaultPlugin == null || !vaultPlugin.isEnabled) {
            return false
        }
        val rsp = server.servicesManager.getRegistration(Economy::class.java) ?: return false
        econ = rsp.provider
        return true
    }
}