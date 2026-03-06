package kr.asturia.player

/**
* 모험가(플레이어)
 * @property uid 플레이어 UUID
 * @property nickname 플레이어 닉네임
 * @property display 플레이어 디스플레이 이름
* */
interface Adventurer {
    val uid: UUID
    val nickname: String
    val display: String

    fun toString(): String {

    }
}