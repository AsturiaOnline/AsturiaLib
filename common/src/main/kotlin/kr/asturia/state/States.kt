package kr.asturia.state

interface States<T: Any> {
    val name: String
    val value: T
}