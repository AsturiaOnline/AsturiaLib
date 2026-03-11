package kr.asturia.asturialib.data

import kr.asturia.asturialib.AsturiaLib
import kr.asturia.asturialib.player.Adventurer
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.cast

class AdventurerData {
    private val plugin = AsturiaLib.instance

    constructor(adventurer: Adventurer) {
        this.adventurer=adventurer
        this.file = File(plugin.dataFolder, "adventurers/${adventurer.uid}.yml")
    }

    constructor(player: OfflinePlayer) {
        this.adventurer = AsturiaLib.adapter.asAdventurer(player)
        this.file = File(plugin.dataFolder, "adventurers/${adventurer.uid}.yml")
    }

    private var adventurer: Adventurer
    private var file: File
    private val config
        get() = YamlConfiguration.loadConfiguration(file)

    private val fronePath = "econ.frone"

    var frone: Double
        get() = config.getDouble(fronePath, 0.0)
        set(value) {
            config.set(fronePath, value)
            save(config)
        }
    var isExist: Boolean
        get() = file.exists()
        set(value) {
            if (value) {
                if (!file.exists()) {
                    file.parentFile.mkdirs()
                    file.createNewFile()
                }
            } else {
                if (file.exists()) {
                    file.delete()
                }
            }
        }

    /**
     * deposit
     * */
    fun addMoney(amount: Double) {
        frone += amount
    }

    /**
     * withdraw
     * */
    fun takeMoney(amount: Double): Boolean {
        if (frone >= amount) {
            frone -= amount
            return true
        }
        return false
    }

    /**
     * @param path 불로올 모험가의 데이터 경로
     * @param type 불러올 데이터의 타입: ex) String::class
     *
     * @return 데이터
     * */
    fun <T: Any> getData(path: String, type: KClass<T>) : T {
        return type.cast(config.get(path))
    }

    fun setData(path: String, value: Any) {
        config.set(path, value)
        save(config)
    }

    fun save(configuration: YamlConfiguration) {
        try {
            configuration.save(file)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}