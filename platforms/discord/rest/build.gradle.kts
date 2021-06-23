@file:Suppress("PropertyName")

plugins {
    application
}

application {
    mainClass.set("dev.nekkan.sixenn.platform.discord.rest.SixennRestAPI")
}

val ktor_version: String by project

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            implementation("io.ktor:ktor-server-core:$ktor_version")
            implementation("io.ktor:ktor-server-netty:$ktor_version")
            implementation("io.ktor:ktor-serialization:$ktor_version")
            api(project(":platforms:discord:database"))
        }
    }
}