@file:JvmName("SixennRestAPI")

package dev.nekkan.sixenn.platform.discord.rest

import dev.nekkan.sixenn.platforms.discord.common.DiscordSixennConfiguration
import dev.nekkan.sixenn.platforms.discord.database.createSixennDatabase
import dev.nekkan.sixenn.platforms.discord.database.tables.Users
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    val database = createSixennDatabase()
    transaction(database) {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Users)
    }
    embeddedServer(Netty, port = DiscordSixennConfiguration.INSTANCE.web.rest.port) {
        install(Compression)
        install(CORS) {
            anyHost()
        }
        install(DefaultHeaders)
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        routing {
            route("/api") {
                get("/hello") {
                    call.respond("Hello, world!")
                }
            }
        }
    }.start(wait = true)
}