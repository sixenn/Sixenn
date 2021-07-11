package dev.nekkan.sixenn.platforms.discord.rest

import dev.nekkan.sixenn.platforms.discord.common.DiscordSixennConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SixennRestApplication

fun main(args: Array<String>) {
    runApplication<SixennRestApplication>(*args) {
        val config = DiscordSixennConfiguration()

        setDefaultProperties(
            mapOf(
                "server.port" to config.discord.server.port,
                "spring.r2dbc.url" to with(config.database) { "r2dbc:postgresql://$user:$password@$host:$port/$database" },
                "spring.r2dbc.name" to config.database.database,
                "spring.r2dbc.username" to config.database.user,
                "spring.r2dbc.password" to config.database.password
            )
        )
    }
}
