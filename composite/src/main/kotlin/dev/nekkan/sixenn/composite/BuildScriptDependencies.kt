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
            const val Core = "dev.kord:kord-core:0.8.0-M7"
            const val Common = "dev.kord:kord-common:0.8.0-M7"
            const val InteraKTions = "net.perfectdreams.discordinteraktions:gateway-kord:0.0.10-SNAPSHOT"
            const val InteraKTionsWebServer =
                "net.perfectdreams.discordinteraktions:webserver-ktor-kord:0.0.10-SNAPSHOT"
            const val Emoji = "dev.kord.x:emoji:0.5.0"
        }
    }

    object Logging {
        const val version = "2.0.10"
        const val KotlinLogging = "io.github.microutils:kotlin-logging-jvm:$version"
        const val Slf4J = "org.slf4j:slf4j-api:1.7.29"
    }

    const val I18nHelper = "net.perfectdreams.i18nhelper:core:0.0.2-SNAPSHOT"
    const val SerializationKaml = "com.charleskorn.kaml:kaml:0.37.0"
}