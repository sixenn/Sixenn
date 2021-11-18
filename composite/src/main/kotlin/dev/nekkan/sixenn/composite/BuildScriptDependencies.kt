package dev.nekkan.sixenn.composite

object BuildScriptDependencies {
    object Kotlin {
        const val version = "1.6.0"
        const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
        const val Serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    }

    object Exposed {
        const val version = "0.34.1"
        const val Core = "org.jetbrains.exposed:exposed-core:$version"
        const val DAO = "org.jetbrains.exposed:exposed-dao:$version"
        const val JDBC = "org.jetbrains.exposed:exposed-jdbc:$version"
        const val Upsert = "pw.forst:exposed-upsert:1.1.0"
    }

    object Ktor {
        const val version = "1.6.5"
        const val Server = "io.ktor:ktor-server-core:$version"
        const val Netty = "io.ktor:ktor-server-netty:$version"
    }

    sealed class Platform {
        object Discord : Platform() {
            const val Kord = "dev.kord:kord-core:0.8.0-M7"
            const val DiscordInteraKTions = "net.perfectdreams.discordinteraktions:webserver-ktor-kord:0.0.9"
        }
    }
}