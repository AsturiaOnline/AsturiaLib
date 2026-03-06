plugins {
    kotlin("jvm")
}

group = "kr.asturia"
version = "0.1-a1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}