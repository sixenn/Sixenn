@file:JvmName("SixennDatabase")

package dev.nekkan.sixenn.platforms.discord.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dev.nekkan.sixenn.platforms.discord.common.DiscordSixennConfiguration
import org.jetbrains.exposed.sql.Database

inline fun createSixennDatabase(): Database {
    val dbConf = DiscordSixennConfiguration.INSTANCE.database

    val hikariDataSource = HikariDataSource(HikariConfig().apply {
        jdbcUrl = "jdbc:postgresql://${dbConf.host}:${dbConf.port}/${dbConf.database}"
        driverClassName = "org.postgresql.Driver"
        username = dbConf.user
        password = dbConf.password
    })

    return Database.connect(hikariDataSource)
}