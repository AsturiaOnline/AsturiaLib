package kr.asturia.api.state

interface States<T: Any> {
    val name: String
    val value: T
}