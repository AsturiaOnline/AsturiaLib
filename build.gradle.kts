plugins {
    kotlin("jvm") version "2.3.10"
//    id("fabric-loom") version "1.15-SNAPSHOT"
}

group = "kr.asturia"
version = "0.1-a1"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
//    apply(plugin = "fabric-loom")

    repositories {
        mavenCentral()
    }

    kotlin {
        jvmToolchain(21)
    }
}
