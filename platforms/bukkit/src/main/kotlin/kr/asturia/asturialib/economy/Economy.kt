package kr.asturia.asturialib.economy

import kr.asturia.asturialib.data.AdventurerData
import net.milkbowl.vault.economy.EconomyResponse
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer

class Economy: net.milkbowl.vault.economy.Economy {
    private val plugin = kr.asturia.asturialib.AsturiaLib.instance
    private val UNIT= "Frone"

    override fun isEnabled(): Boolean = plugin.isEnabled
    override fun getName(): String = "AsturiaLib Economy"

    override fun hasBankSupport(): Boolean = false

    override fun fractionalDigits(): Int = 0

    override fun format(amount: Double): String = amount.toString() + UNIT

    override fun currencyNamePlural(): String = currencyNameSingular()

    override fun currencyNameSingular(): String = UNIT

    @Deprecated("Deprecated in Java", ReplaceWith("hasAccount(Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit"))
    override fun hasAccount(playerName: String): Boolean {
        return hasAccount(Bukkit.getPlayer(playerName))
    }

    override fun hasAccount(player: OfflinePlayer?): Boolean {
        return AdventurerData(player ?: return false).isExist
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("hasAccount(Bukkit.getPlayer(playerName), world)", "org.bukkit.Bukkit")
    )
    override fun hasAccount(playerName: String, world: String): Boolean {
        return hasAccount(Bukkit.getPlayer(playerName), world)
    }

    override fun hasAccount(player: OfflinePlayer?, world: String): Boolean {
        return hasAccount(player)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("getBalance(Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit"))
    override fun getBalance(playerName: String): Double {
        return getBalance(Bukkit.getPlayer(playerName))
    }

    override fun getBalance(player: OfflinePlayer?): Double {
        return AdventurerData(player ?: return 0.0).frone
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("getBalance(Bukkit.getPlayer(playerName), world)", "org.bukkit.Bukkit")
    )
    override fun getBalance(playerName: String, world: String): Double {
        return getBalance(Bukkit.getPlayer(playerName), world)
    }

    override fun getBalance(player: OfflinePlayer?, world: String): Double {
        return getBalance(player)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("has(Bukkit.getPlayer(playerName), amount)", "org.bukkit.Bukkit"))
    override fun has(playerName: String, amount: Double): Boolean {
        return has(Bukkit.getPlayer(playerName), amount)
    }

    override fun has(player: OfflinePlayer?, amount: Double): Boolean {
        val bal = getBalance(player)
        return bal>=amount
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("has(Bukkit.getPlayer(playerName), world, amount)", "org.bukkit.Bukkit")
    )
    override fun has(playerName: String, world: String, amount: Double): Boolean {
        return has(Bukkit.getPlayer(playerName), world, amount)
    }

    override fun has(player: OfflinePlayer?, world: String, amount: Double): Boolean {
        return has(player, amount)
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("withdrawPlayer(Bukkit.getPlayer(playerName), amount)", "org.bukkit.Bukkit")
    )
    override fun withdrawPlayer(playerName: String, amount: Double): EconomyResponse {
        return withdrawPlayer(Bukkit.getPlayer(playerName), amount)
    }

    override fun withdrawPlayer(player: OfflinePlayer?, amount: Double): EconomyResponse {
        val userData=
            AdventurerData(player ?: return EconomyResponse(amount, amount, EconomyResponse.ResponseType.FAILURE, "cant find player"))
        userData.takeMoney(amount)
        return EconomyResponse(amount, userData.frone, EconomyResponse.ResponseType.SUCCESS, null)
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("withdrawPlayer(Bukkit.getPlayer(playerName), world, amount)", "org.bukkit.Bukkit")
    )
    override fun withdrawPlayer(playerName: String, world: String, amount: Double): EconomyResponse {
        return withdrawPlayer(Bukkit.getPlayer(playerName), world, amount)
    }

    override fun withdrawPlayer(player: OfflinePlayer?, world: String, amount: Double): EconomyResponse {
        return withdrawPlayer(player, amount)
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("depositPlayer(Bukkit.getPlayer(playerName), amount)", "org.bukkit.Bukkit")
    )
    override fun depositPlayer(playerName: String, amount: Double): EconomyResponse {
        return depositPlayer(Bukkit.getPlayer(playerName), amount)
    }

    override fun depositPlayer(player: OfflinePlayer?, amount: Double): EconomyResponse {
        val userData=
            AdventurerData(player ?: return EconomyResponse(amount, amount, EconomyResponse.ResponseType.FAILURE, "cant find player"))
        userData.addMoney(amount)
        return EconomyResponse(amount, userData.frone, EconomyResponse.ResponseType.SUCCESS, null)
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("depositPlayer(Bukkit.getPlayer(playerName), world, amount)", "org.bukkit.Bukkit")
    )
    override fun depositPlayer(playerName: String, world: String, amount: Double): EconomyResponse {
        return depositPlayer(Bukkit.getPlayer(playerName), world, amount)
    }

    override fun depositPlayer(player: OfflinePlayer?, world: String, amount: Double): EconomyResponse {
        return depositPlayer(player, amount)
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("createBank(bank, Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit")
    )
    override fun createBank(bank: String, playerName: String): EconomyResponse {
        return createBank(bank, Bukkit.getPlayer(playerName))
    }

    override fun createBank(bank: String, player: OfflinePlayer?): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun deleteBank(bank: String): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun bankBalance(bank: String): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun bankHas(bank: String, amount: Double): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun bankWithdraw(bank: String, amount: Double): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun bankDeposit(bank: String, amount: Double): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("isBankMember(bank, Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit")
    )
    override fun isBankOwner(bank: String, playerName: String): EconomyResponse {
        return isBankMember(bank, Bukkit.getPlayer(playerName))
    }

    override fun isBankOwner(bank: String, player: OfflinePlayer?): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("isBankMember(bank, Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit")
    )
    override fun isBankMember(bank: String, playerName: String): EconomyResponse {
        return isBankMember(bank, Bukkit.getPlayer(playerName))
    }

    override fun isBankMember(bank: String, player: OfflinePlayer?): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Not Supported Function")
    }

    override fun getBanks(): MutableList<String> {
        return mutableListOf()
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("createPlayerAccount(Bukkit.getPlayer(playerName))", "org.bukkit.Bukkit")
    )
    override fun createPlayerAccount(playerName: String): Boolean {
        return createPlayerAccount(Bukkit.getPlayer(playerName))
    }

    override fun createPlayerAccount(player: OfflinePlayer?): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("createPlayerAccount(Bukkit.getPlayer(playerName), world)", "org.bukkit.Bukkit")
    )
    override fun createPlayerAccount(playerName: String, world: String): Boolean {
        return createPlayerAccount(Bukkit.getPlayer(playerName), world)
    }

    override fun createPlayerAccount(player: OfflinePlayer?, world: String): Boolean {
        return createPlayerAccount(player)
    }
}